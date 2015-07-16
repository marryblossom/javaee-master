package com.tw.core.service.baseService.impl;

import com.tw.core.service.baseService.BaseService;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
@Transactional
@Repository
public class BaseServiceImpl implements BaseService {
    private static Session session;
    static {
        session = HibernateUtil.getSessionFactory().openSession();
    }
  //  @Autowired
 //   private SessionFactory sessionFactory;

//    public Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }
    @Override
    public Session getCurrentSession() {
        return session;
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
        session.beginTransaction();//开启操作数据库的事务
        session.delete(findById(clazz, id));
        session.getTransaction().commit();
    }

    @Override
    public void save(Object object) {
        session.beginTransaction();//开启操作数据库的事务
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();//开启操作数据库的事务
        getCurrentSession().update(object);
        session.getTransaction().commit();

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
