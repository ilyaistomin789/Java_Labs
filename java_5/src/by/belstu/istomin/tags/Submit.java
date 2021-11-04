package by.belstu.istomin.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class Submit extends TagSupport {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (type != null) {
                if (type.equals("OK")) {
                    pageContext.getOut().write("<input type='submit' value='OK'/>");
                } else if (type.equals("CANCEL")) {
                    pageContext.getOut().write("<input type='reset' value='CANCEL'/>");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return SKIP_BODY;
    }
}
