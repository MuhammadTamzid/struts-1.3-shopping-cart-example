package com.cart.form;

import org.apache.struts.action.ActionForm;

public class TestForm extends ActionForm {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
