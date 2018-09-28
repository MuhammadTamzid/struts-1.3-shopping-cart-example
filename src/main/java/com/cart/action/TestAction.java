package com.cart.action;

import com.cart.form.CategoryForm;
import com.cart.form.TestForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        TestForm testForm = (TestForm) form;
        testForm.setText("Test");

//        HttpSession session = request.getSession();
//        session.setAttribute("TestForm", testForm);



        return mapping.findForward("success");
    }
}
