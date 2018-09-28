package com.cart.action;

import com.cart.factory.DBSessionFactory;
import com.cart.form.CategoryForm;
import com.cart.model.Category;
import com.cart.persistence.CategoryRepo;
import com.cart.service.CategoryService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

public class CategoryAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        CategoryRepo categoryRepo = new CategoryRepo();
        CategoryService categoryService = new CategoryService(categoryRepo);

//        DBSessionFactory.start();
//        Session session = DBSessionFactory.currentSession();

        CategoryForm categoryForm = (CategoryForm) form;
        Category category = new Category();
        BeanUtils.copyProperties(category, categoryForm);

        boolean success = categoryService.createCategory(category);

//        session.beginTransaction();
//        session.save(category);
//        session.getTransaction().commit();

//        HttpSession session = request.getSession();
//        session.setAttribute("CategoryForm", categoryForm);

        if (success) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("error");
        }
    }
}
