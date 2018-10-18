package com.mbstu.ehcare.controller.LogicDoc;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Tanmoy on 4/23/2017.
 * Updated by Tanmoy on 4/23/2017.
 */
@Repository
@Transactional
public class LogiDocDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }


    public void saveLogidocData(LogiDocSettingsEntity logiDocSettingsEntity){
        getSession().saveOrUpdate(logiDocSettingsEntity);
    }

    public LogiDocSettingsEntity findLogiDocData(){
        Criteria criteria = getSession().createCriteria(LogiDocSettingsEntity.class);
        return (LogiDocSettingsEntity) criteria.list().get(0);
    }
}
