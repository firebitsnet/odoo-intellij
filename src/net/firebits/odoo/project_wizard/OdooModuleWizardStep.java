package net.firebits.odoo.project_wizard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

public class OdooModuleWizardStep extends ModuleWizardStep {
    @Override
    public JComponent getComponent() {
        return new JLabel("Provide some setting here");
    }

    @Override
    public void updateDataModel() {
        //todo update model according to UI
    }
}