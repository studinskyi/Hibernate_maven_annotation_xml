package com.journaldev.hibernate.model;

import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String role;
    private Date insertTime;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public static void getListEmployee() {

        Session session = null;
        List<Employee> listEmployees = new ArrayList<Employee>();
        try {
            // вывод всего списка записанных в базу Employee
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //Query query = session.createQuery("from Employee");
            Query query = session.createQuery("from Employee where name = :nameEmployee ");
            query.setParameter("nameEmployee", "David");
            listEmployees = (List<Employee>) query.list();
            for (Employee el : listEmployees)
                System.out.println(el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime());

            //System.out.println(el.toString());
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
