// Copyright 2000-2017 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package net.firebits.odoo.actions;

import com.intellij.ide.IdeBundle;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDirectory;
import com.jetbrains.python.PythonFileType;
import com.jetbrains.python.pyi.PyiFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author yole
 */
public class CreateOdooManifestAction extends CreateFileFromTemplateAction implements DumbAware {

  @NonNls private static final String DEFAULT_ODOO_MANIFEST_TEMPLATE_PROPERTY = "DefaultOdooManifestFileTemplate";


  public CreateOdooManifestAction() {
    super("Odoo Manifest File", "Creates an Odoo Manifest Python file from the specified template", PythonFileType.INSTANCE.getIcon());
  }

  @Override
  protected String getDefaultTemplateProperty() {
    return DEFAULT_ODOO_MANIFEST_TEMPLATE_PROPERTY;
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder
      .setTitle("New Odoo Manifest file")
      .addKind("Python file", PythonFileType.INSTANCE.getIcon(), "OdooManifest");
  }

  @Override
  protected String getActionName(PsiDirectory directory, @NotNull String newName, String templateName) {
    return "Create Odoo Manifest script " + newName;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @NotNull
  @Override
  protected String getErrorTitle() {
    return IdeBundle.message("title.cannot.create.class");
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof CreateOdooManifestAction;
  }
}