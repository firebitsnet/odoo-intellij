package icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * @author Amr Abd-Alkrim
 */
public class OdooIcons {
  private static Icon load(String path) {
    return IconLoader.getIcon(path, OdooIcons.class);
  }

  public static final Icon Odoo = load("/icons/odoo.png");
  public static final Icon OdooIcon = load("/icons/odoo_small.png");
  public static final Icon FireBits = load("/icons/firebits.png");
}
