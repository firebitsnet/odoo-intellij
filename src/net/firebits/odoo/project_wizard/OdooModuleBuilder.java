package net.firebits.odoo.project_wizard;

import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.WriteAction;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleWithNameAlreadyExists;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import static java.util.Arrays.asList;

/**
 * @author Anna Bulenkova
 */
public class OdooModuleBuilder extends ModuleBuilder {

    public void setupRootModel(ModifiableRootModel model) throws ConfigurationException{
        doAddContentEntry(model);
        // Add a reference to Dart SDK project library, without committing.
        model.addInvalidLibrary("Python SDK", "project");
    }

    public ModuleType getModuleType() {
        return OdooModuleType.getInstance(); //or it could be other module type
    }

    @Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new OdooModuleWizardStep();
    }

    @Nullable
    private static VirtualFile findOdooModuleFile(@NotNull VirtualFile baseDir, String odooModuleName) {
        baseDir.refresh(false, false);
        for (String name : asList(odooModuleName + "_odoo.iml", "odoo.iml")) {
            final VirtualFile candidate = baseDir.findChild(name);
            if (candidate != null && candidate.exists()) {
                return candidate;
            }
        }
        return null;
    }


    @Nullable
    @Override
    public com.intellij.openapi.module.Module commitModule(@NotNull Project project, @Nullable ModifiableModuleModel model) {
        final String basePath = getModuleFileDirectory();
        if (basePath == null) {
            Messages.showErrorDialog("Module path not set", "Internal Error");
            return null;
        }
        final VirtualFile baseDir = LocalFileSystem.getInstance().refreshAndFindFileByPath(basePath);
        if (baseDir == null) {
            Messages.showErrorDialog("Unable to determine Flutter project directory", "Internal Error");
            return null;
        }
//
//        final FlutterSdk sdk = getFlutterSdk();
//        if (sdk == null) {
//            Messages.showErrorDialog("Flutter SDK not found", "Error");
//            return null;
//        }

//        final OutputListener listener = new OutputListener();
//        final PubRoot root = runFlutterCreateWithProgress(baseDir, sdk, project, listener, getAdditionalSettings());
//        if (root == null) {
//            final String stderr = listener.getOutput().getStderr();
//            final String msg = stderr.isEmpty() ? "Flutter create command was unsuccessful" : stderr;
//            final int code = FlutterMessages.showDialog(project, msg, "Project Creation Error", new String[]{"Run Flutter Doctor", "Cancel"}, 0);
//            if (code == 0) {
//                new FlutterDoctorAction().startCommand(project, sdk, null);
//            }
//            return null;
//        }
//        FlutterSdkUtil.updateKnownSdkPaths(sdk.getHomePath());

        // Create the Flutter module. This indirectly calls setupRootModule, etc.
        final Module flutter = super.commitModule(project, model);
        if (flutter == null) {
            return null;
        }

        addOdooModule(project, model, basePath, flutter.getName());
        return flutter;
    }


    private static void addOdooModule(@NotNull Project project,
                                         @Nullable ModifiableModuleModel model,
                                         @NotNull String baseDirPath,
                                         @NotNull String flutterModuleName) {
        final VirtualFile baseDir = LocalFileSystem.getInstance().refreshAndFindFileByPath(baseDirPath);
        if (baseDir == null) {
            return;
        }

        final VirtualFile androidFile = findOdooModuleFile(baseDir, flutterModuleName);
        if (androidFile == null) return;

        try {
            final ModifiableModuleModel toCommit;
            if (model == null) {
                toCommit = ModuleManager.getInstance(project).getModifiableModel();
                //noinspection AssignmentToMethodParameter
                model = toCommit;
            }
            else {
                toCommit = null;
            }

            model.loadModule(androidFile.getPath());

            if (toCommit != null) {
                WriteAction.run(toCommit::commit);
            }
        }
        catch (ModuleWithNameAlreadyExists | IOException e) {
//            FlutterUtils.warn(LOG, e);
        }
    }
}
