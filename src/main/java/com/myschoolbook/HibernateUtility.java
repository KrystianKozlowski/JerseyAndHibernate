package com.myschoolbook;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Krystian on 2017-05-23.
 */
public class HibernateUtility {

        public static SessionFactory factory;
        //to disallow creating objects by other classes.

        private HibernateUtility() {
        }

        //ensures that a method can be invoked by only one thread at a time
        public static synchronized SessionFactory getSessionFactory() {

            if (factory == null) {
                factory = new Configuration().configure("hibernate.cfg.xml").
                        buildSessionFactory();
            }
            return factory;
        }
    }
