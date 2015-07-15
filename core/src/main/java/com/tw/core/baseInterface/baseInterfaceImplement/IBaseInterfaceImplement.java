package com.tw.core.baseInterface.baseInterfaceImplement;

import com.tw.core.baseInterface.IBaseInterface;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
public class IBaseInterfaceImplement implements IBaseInterface {
  //  @Autowired
 //   private SessionFactory sessionFactory;

//    public Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }
    @Override
    public Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void closeCurrentSession(Session session) {
        session.close();
    }

    @Override
   // @Transactional()
    public void delete(Object object) {
        getCurrentSession().delete(object);

    }

    @Override
    public void saveOrUpdate(Object object) {
        getCurrentSession().saveOrUpdate(object);

    }

    @Override
   // @SuppressWarnings("unchecked")
    public <T> List<T> queryAll(Class<T> clazz) {
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        List<T> list = criteria.list();
        return list;
    }

    @Override
    public void deleteById(Class<?> clazz, String id) {
        delete(findById(clazz, id));
    }

    @Override
    public void save(Object object) {
        getCurrentSession().save(object);

    }

    @Override
    public void update(Object object) {
        getCurrentSession().update(object);

    }

    @Override
    public <T> List<T> queryAllOfCondition(Class<T> clazz,
                                           DetachedCriteria dCriteria) {
        Criteria criteria = dCriteria
                .getExecutableCriteria(getCurrentSession());
        List<T> list = criteria.list();
        return list;
    }

    @Override
    public <T> void deleteAll(List<T> list) {
        for (T object : list) {
            getCurrentSession().delete(object);
        }
    }

    @Override
    public <T> void saveAll(List<T> list) {
        for (T object : list) {
            getCurrentSession().save(object);
        }
    }

    @Override
    public <T> void updateAll(List<T> objList) {
        for (T object : objList) {
            getCurrentSession().update(object);
        }
    }

    @Override
    public <T> T findById(Class<T> clazz, String id) {

        return (T) getCurrentSession().get(clazz, id);
    }


}
