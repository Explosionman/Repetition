package ru.rybinskov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class MyDao<T, ID extends Long> {

    private Class<T> clazz;
    private Class<ID> idClazz;
    private SessionFactory factory;

    public MyDao(Class<T> clazz, Class<ID> idClazz) {
        this.clazz = clazz;
        this.idClazz = idClazz;
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }

    public MyDao() {
    }

    public void save(T entity) {
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public T findById(ID id) {
        T entity = null;
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            entity = session.find(clazz, id);
            session.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<T> findAll() {
        List<T> entities;
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            entities = session.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
            session.getTransaction().commit();
        }
        return entities;
    }

    public List<T> saveAll(List<T> entities) {
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            for (T entity : entities) {
                if (entity == null) {
                    session.getTransaction().rollback();
                    return Arrays.asList();
                }
                session.saveOrUpdate(entity);
            }
            session.getTransaction().commit();
        }
        return entities;
    }

    public void deleteById(ID id) {
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            T entity = session.find(clazz, id);
            session.remove(entity);
            session.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void delete(T entity) {
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

}
