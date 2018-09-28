package com.cart.persistence;

import com.cart.factory.DBSessionFactory;
import com.cart.model.Category;
import org.hibernate.Session;

public class CategoryRepo implements ICategoryRepo {

    @Override
    public boolean createCategory(Category category) {
        try {
            DBSessionFactory.start();
            Session session = DBSessionFactory.currentSession();

            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
