package com.tw.core.DAO;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
public interface IBaseDao {
    Session getCurrentSession();

    void closeCurrentSession(Session session);

    void delete(Object object);

    <T> void deleteAll(List<T> list);

    void saveOrUpdate(Object object);

    void save(Object object);

    <T> void saveAll(List<T> list);

    void update(Object object);

    <T> void updateAll(List<T> objList);

    public<T> List<T> queryAll(Class<T> clazz);

    <T> List<T> queryAllOfCondition(Class<T> clazz,DetachedCriteria dCriteria);

    <T> T findById(Class<T> clazz, String id);

    void deleteById(Class<?> clazz, String id);
}
