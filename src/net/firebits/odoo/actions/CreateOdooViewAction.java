// Copyright 2000-2017 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package net.firebits.odoo.actions;

import com.intellij.ide.IdeBundle;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.jetbrains.python.PythonFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author yole
 */
public class CreateOdooViewAction extends CreateFileFromTemplateAction implements DumbAware {

  @NonNls private static final String DEFAULT_ODOO_VIEW_TEMPLATE_PROPERTY = "DefaultOdooViewFileTemplate";


  public CreateOdooViewAction() {
    super("Odoo View File", "Creates an Odoo View Python file from the specified template", PythonFileType.INSTANCE.getIcon());
  }

  @Override
  protected String getDefaultTemplateProperty() {
    return DEFAULT_ODOO_VIEW_TEMPLATE_PROPERTY;
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder
      .setTitle("New Odoo View file")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooView");
  }

  @Override
  protected String getActionName(PsiDirectory directory, @NotNull String newName, String templateName) {
    return "Create Odoo View  " + newName;
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
    return obj instanceof CreateOdooViewAction;
  }
}