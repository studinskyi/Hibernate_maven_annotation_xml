package com.journaldev.hibernate.model;

import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Nickname {
    private int id;
    private String name;
    private Employee employee;

    //Hibernate requires no-args constructor
    public Nickname() {
    }

    @Override
    public String toString() {
        String strNickname = " Nickname " + id + " " + name;
        return strNickname;
    }

    public Nickname(int id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static List<Nickname> getListAllNicknames() {
        Session session = null;
        List<Nickname> listNickname = new ArrayList<Nickname>();

        try {
            // вывод всего списка записанных в базу Nickname
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Nickname");
            listNickname = (List<Nickname>) query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listNickname;
    }
}
