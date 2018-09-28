package com.cart.factory;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class FactoryHelper {

    public static Configuration loadDBConfigAsConfiguration(String configFile) throws HibernateException {
        return new Configuration().configure(FactoryHelper.class.getClassLoader().getResource(configFile));
    }
}
