package net.firebits.odoo.framwork;

import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.*;
import com.intellij.icons.AllIcons;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.*;
import icons.OdooIcons;
import net.firebits.odoo.OdooBundle;
import net.firebits.odoo.project_wizard.OdooModuleType;
import org.jetbrains.annotations.*;

import javax.swing.*;

/**
 * @author Anna Bulenkova
 */
public class OdooFramework extends FrameworkTypeEx {
  public static final String FRAMEWORK_ID = "Odoo";

  protected OdooFramework() {
    super(FRAMEWORK_ID);
  }

  @NotNull
  @Override
  public FrameworkSupportInModuleProvider createProvider() {
    return new FrameworkSupportInModuleProvider() {
      @NotNull
      @Override
      public FrameworkTypeEx getFrameworkType() {
        return OdooFramework.this;
      }

      @Override
      public String getVersionLabel() {
        return "v12.0";
      }

      @NotNull
      @Override
      public FrameworkSupportInModuleConfigurable createConfigurable(@NotNull FrameworkSupportModel model) {
        return new FrameworkSupportInModuleConfigurable() {
          @Nullable
          @Override
          public JComponent createComponent() {
            return new JCheckBox("Extra Option");
          }

          @Override
          public void addSupport(@NotNull Module module,
                                 @NotNull ModifiableRootModel model,
                                 @NotNull ModifiableModelsProvider provider) {
            //do what you want here: setup a library, generate a specific file, etc

            module.setModuleType(OdooBundle.message("odoo.module.name"));
          }
        };
      }

      @Override
      public boolean isEnabledForModuleType(@NotNull ModuleType type) {
        return true;
      }
    };
  }

  @NotNull
  @Override
  public String getPresentableName() {
    return "Odoo Framework";
  }

  @NotNull
  @Override
  public Icon getIcon() {
    return OdooIcons.OdooIcon;
  }
}
