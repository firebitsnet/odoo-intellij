package net.firebits.odoo.project_wizard;

import net.firebits.odoo.OdooBundle;

public enum OdooProjectType {
  APP(OdooBundle.message("odoo.module.create.settings.type.application"), "app"),
  PLUGIN(OdooBundle.message("odoo.module.create.settings.type.plugin"), "plugin"),
  PACKAGE(OdooBundle.message("odoo.module.create.settings.type.package"), "package"),
  MODULE(OdooBundle.message("odoo.module.create.settings.type.module"), "module"),
  IMPORT(OdooBundle.message("odoo.module.create.settings.type.import_module"), "module");

  final public String title;
  final public String arg;

  OdooProjectType(String title, String arg) {
    this.title = title;
    this.arg = arg;
  }

  public String toString() {
    return title;
  }
}
