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
 * @author Amr Abd-Alkrim
 */
public class CreateOdooViewAction extends CreateFileFromTemplateAction implements DumbAware {

  @NonNls private static final String DEFAULT_ODOO_VIEW_TEMPLATE_PROPERTY = "DefaultOdooViewFileTemplate";


  public CreateOdooViewAction() {
    super("Odoo View File", "Creates an Odoo View XML file from the specified template", XmlFileType.INSTANCE.getIcon());
  }

  @Override
  protected String getDefaultTemplateProperty() {
    return DEFAULT_ODOO_VIEW_TEMPLATE_PROPERTY;
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder
      .setTitle("New Odoo View file")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewEmpty")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewBasic")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewAdvanced")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewInherit")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewReport")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewSecurity")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewSequence")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewSettings")
      .addKind("XML file", XmlFileType.INSTANCE.getIcon(), "OdooViewCronJob");
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