package db;

import models.File;
import models.Folder;
import models.Owner;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {
    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void update(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //    TODO: FindAll method
//    We want find all to return a list of generic things
//    public static TYPE List<TYPE> getAll(Class classType)
    public static <T> List<T> getAll(Class classType){
        List<T> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try{
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }


    public static <Whatever> Whatever findById(Class classType, int id){
        Whatever result = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try{
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (Whatever) cr.uniqueResult();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }
}