package com.myschoolbook.service;

import com.myschoolbook.HibernateUtility;
import com.myschoolbook.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Krystian on 2017-05-03.
 */
public class MessageService {

    //private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Message> getAllMessages(){

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        List<Message> messageList = session.createQuery("from Message").list();
        session.close();
        return messageList;
    }

    public Message getMessageById(int id){

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Message message = (Message) session.get(Message.class, new Integer(id));
        session.close();
        return message;

    }

    public Message addMessage(Message message){

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(message);
        session.close();
        return message;

    }

    public Message updateMessage( int id , Message messageNew) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Message messageOld = (Message) session.get(Message.class, new Integer(id));
        messageOld.setMessage(messageNew.getMessage());
        messageOld.setAuthor(messageNew.getAuthor());
        messageOld.setCreated(messageNew.getCreated());
        session.update(messageOld);
        session.close();
        return messageOld;
    }

    public void removeMessage(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Message message = (Message) session.get(Message.class, new Integer(id));
        session.remove(message);
        session.close();
    }
}
