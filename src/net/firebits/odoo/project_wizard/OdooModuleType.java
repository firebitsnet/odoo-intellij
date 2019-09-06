package net.firebits.odoo.project_wizard;

import com.intellij.icons.AllIcons;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import icons.OdooIcons;
import net.firebits.odoo.OdooBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OdooModuleType extends ModuleType<OdooModuleBuilder> {
    private static final String ID = "FIRE_ODOO_MOULE_TYPE";

    public OdooModuleType() {
        super(ID);
    }

    public static OdooModuleType getInstance() {
        return (OdooModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }

    @NotNull
    @Override
    public OdooModuleBuilder createModuleBuilder() {
        return new OdooModuleBuilder();
    }

    private Project myProject;

    @Override
    public String getName() {
        return getPresentableName();
    }

    @Nullable
    public Project getProject() {
        return myProject; // Non-null when creating a module.
    }

    public String getPresentableName() {
        return OdooBundle.message("odoo.module.name");
    }

    @Override
    public String getDescription() {
        return OdooBundle.message("odoo.project.description");
    }

    @Override
    public Icon getNodeIcon(@Deprecated boolean b) {
        return OdooIcons.OdooIcon;
    }
}