package net.firebits.odoo.template;

import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author Amr Abd-Alkrim
 */
public class OdooXMLContextMenu extends TemplateContextType {
    protected OdooXMLContextMenu() {
        super("XML", "XML");
    }

    @Override
    public boolean isInContext(@NotNull PsiFile file, int offset) {
        return file.getName().endsWith(".xml");
    }
}