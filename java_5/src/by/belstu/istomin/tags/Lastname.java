package by.belstu.istomin.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Lastname extends TagSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write(String.format("<input type='text' name='%s'/>", this.name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
