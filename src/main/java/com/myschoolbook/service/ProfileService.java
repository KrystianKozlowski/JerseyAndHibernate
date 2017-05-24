package com.myschoolbook.service;

import com.myschoolbook.HibernateUtility;
import com.myschoolbook.model.Profile;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Krystian on 2017-05-23.
 */
public class ProfileService {
    public List<Profile> getAllProfiles(){

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        List<Profile> profileList = session.createQuery("from Profile").list();
        session.close();
        return profileList;
    }

    public Profile getProfileByName(String name){
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Profile profile = (Profile) session.createQuery("from Profile as profile where  profile.name='" + name + "'").getSingleResult();
        session.close();
        return profile;

    }

    public Profile addProfile(Profile profile){

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(profile);
        session.close();
        return profile;

    }

    public Profile updateMessage( String profileName , Profile profileNew) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Profile profileOld = (Profile) session.createQuery("from Profile as profile where profile.name='" + profileName + "'").getSingleResult();
        profileOld.setEmail(profileNew.getEmail());
        profileOld.setCreated(profileNew.getCreated());
        session.update(profileOld);
        session.close();
        return profileOld;
    }

    public void removeProfile(String profileName) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Profile profile = (Profile) session.createQuery("from Profile as profile where profile.name='" + profileName + "'").getSingleResult();
        session.remove(profile);
        session.close();
    }
}
