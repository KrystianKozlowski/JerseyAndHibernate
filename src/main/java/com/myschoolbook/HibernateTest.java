package com.myschoolbook;

import com.myschoolbook.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Krystian on 2017-05-03.
 */
public class HibernateTest {
    public static void main(String[] args) {
        Message ms = new Message("Cześć, tu Basia", "Basia");

        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(ms);
//        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();

        ms = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        ms =(Message) session.get(Message.class, 1);

        System.out.println("Your message: " + ms.getMessage() + " " + String.valueOf(ms.getId()));

    }
}
