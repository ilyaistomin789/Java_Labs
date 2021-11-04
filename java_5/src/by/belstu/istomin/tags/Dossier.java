package by.belstu.istomin.tags;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Dossier extends TagSupport {
    private String action = "";

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write(String.format("<form method = 'post' action= '%s'>", this.action));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("</form>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_PAGE;
    }
}
