package com.dsr.Dao.Impl;

import com.dsr.Dao.FileUploadDao;
import com.dsr.Model.infoExcel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FileUploadDaoImpl implements FileUploadDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addExcel(infoExcel infoExcel) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(infoExcel);
        session.flush();
    }
}
