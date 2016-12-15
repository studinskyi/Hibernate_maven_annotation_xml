package com.journaldev.hibernate.dao.impl;

import com.journaldev.hibernate.dao.NicknameDao;
import com.journaldev.hibernate.model.Nickname;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class NicknameDaoimpl implements NicknameDao {

    public List<Nickname> getListAllNicknames() {
        // вывод всего списка записанных в базу Nickname
        List<Nickname> listNickname = new ArrayList<Nickname>();
        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        try {
            Query query = session.createQuery(SQL_FIND_ALL);
            //Query query = session.createQuery("from Nickname");
            listNickname = (List<Nickname>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return listNickname;
    }

}
