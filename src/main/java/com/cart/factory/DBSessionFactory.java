package com.cart.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBSessionFactory {

    // sessionFactory instance
    private static SessionFactory  _sessionFactory = null ;

    //contain session of currentThread
    private static ThreadLocal  _threadLocal = new ThreadLocal();

    //counter of current session
    private static ThreadLocal  _counter = new ThreadLocal();

    //config file
    private static final String  DB_CONFIG_FILE = "hibernate.cfg.xml";

    static {
        try {
            _sessionFactory = buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            String errorMsg =
                    " could not read  content from DB2.hbm.xml" +
                            " and build a session factory ";
        }
    }

    private static SessionFactory buildSessionFactory() throws Exception {
        Configuration cfg = FactoryHelper.loadDBConfigAsConfiguration(DB_CONFIG_FILE);
        SessionFactory factory = cfg.buildSessionFactory();
        return  factory ;
    }

    /*************************************************************
     * generate a session and put it to ThreadLocal.
     * @throws HibernateException
     *************************************************************/
    public static void start()
            throws HibernateException {
        try{
            Object  obj = _threadLocal.get();

            if( null == obj ){
                _threadLocal.set( _sessionFactory.openSession());
                Integer  initValue = new Integer(1);
                _counter.set( initValue );
            }
            else {
                Integer  currentValue = (Integer)_counter.get();
                currentValue = new Integer( currentValue.intValue() + 1);
                _counter.set( currentValue );
            }
        }catch( HibernateException ex ){
            _threadLocal.set( null );
            _counter.set( null );
            throw ex ;
        }
    }

    /**************************************************************
     * close and remove session from ThreadLocal
     * @throws HibernateException
     **************************************************************/
    public static void end()
            throws HibernateException {
        try{
            Integer  currentValue = (Integer)_counter.get();
            if( currentValue == null ){
                return ;
            }
            int iCurrentValue = currentValue.intValue();
            if( iCurrentValue == 1 ){
                Object  obj = _threadLocal.get();
                Session session = (Session)obj ;
                session.close();
                _threadLocal.set(null);
            }
            else {
                currentValue = new Integer( iCurrentValue - 1);
                _counter.set( currentValue );
            }
        }catch( HibernateException ex ){
            _threadLocal.set( null );
            _counter.set( null );
            throw ex ;
        }
    }

    /**************************************************************
     * obtain current session from ThreadLocal
     * @return current Session
     * @throws HibernateException
     **************************************************************/
    public static Session currentSession()
            throws HibernateException{
        Object  obj = _threadLocal.get();
        if( null == obj ){
            throw new NullPointerException("currentSession DB2 Null Exception") ;
        }
        return (Session)obj ;
    }
}
