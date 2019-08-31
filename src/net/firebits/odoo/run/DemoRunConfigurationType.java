package net.firebits.odoo.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author Anna Bulenkova
 */
public class DemoRunConfigurationType implements ConfigurationType {
  @Override
  public String getDisplayName() {
    return "Odoo";
  }

  @Override
  public String getConfigurationTypeDescription() {
    return "Odoo Run Configuration Type";
  }

  @Override
  public Icon getIcon() {
    return AllIcons.General.Information;
  }

  @NotNull
  @Override
  public String getId() {
    return "DEMO_RUN_CONFIGURATION";
  }

  @Override
  public ConfigurationFactory[] getConfigurationFactories() {
    return new ConfigurationFactory[]{new DemoConfigurationFactory(this)};
  }
}
