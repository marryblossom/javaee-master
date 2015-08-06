package com.tw.core.DAO.impl;

import com.tw.core.DAO.IBaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
@Service
@Transactional
@EnableTransactionManagement
public class BaseServiceImpl implements IBaseDao {
    @Autowired
    private SessionFactory sessionFactory;
//    static {
//        session = HibernateUtil.getSessionFactory().openSession();
//    }
    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void closeCurrentSession(Session session) {
        session.close();
    }

    @Override
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
//        getCurrentSession().beginTransaction();//开启操作数据库的事务
        getCurrentSession().delete(findById(clazz, id));
//        getCurrentSession().getTransaction().commit();
    }

    @Override
    public void save(Object object) {
        getCurrentSession().save(object);
    }

    @Override
    public void update(Object object) {
        getCurrentSession().update(object);
//        // if you're doing transactional work
//        session.setFlushMode(FlushMode.COMMIT);
//        // if you want to control flushes directly
//        session.setFlushMode(FlushMode.MANUAL);

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
        return (T) getCurrentSession().load(clazz, id);
//        return (T) getCurrentSession().get(clazz, id);
    }


}
