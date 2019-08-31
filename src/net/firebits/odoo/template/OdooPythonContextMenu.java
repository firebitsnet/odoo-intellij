package net.firebits.odoo.template;

import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class OdooPythonContextMenu extends TemplateContextType {
    protected OdooPythonContextMenu() {
        super("Python", "Python");
    }

    @Override
    public boolean isInContext(@NotNull PsiFile file, int offset) {
        return file.getName().endsWith(".py");
    }
}