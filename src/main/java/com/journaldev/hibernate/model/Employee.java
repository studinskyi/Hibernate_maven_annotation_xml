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

    @Override
    public String toString() {
        String strEmployee = "Employee: " + id + " " + name + " " + role + " " + insertTime;
        //el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime();
        return strEmployee;
    }

    public static List<Employee> getListEmployeeByName(String nameEmpl) {

        Session session = null;
        List<Employee> listEmployees = new ArrayList<Employee>();

        try {
            // вывод Employee по имени
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where name = :nameEmployee ");
            query.setParameter("nameEmployee", nameEmpl);
            listEmployees = (List<Employee>) query.list();
            //            for (Employee el : listEmployees)
            //                System.out.println(el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime());
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }

    public static List<Employee> getListAllEmployee() {
        Session session = null;
        List<Employee> listEmployees = new ArrayList<Employee>();

        try {
            // вывод всего списка записанных в базу Employee
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee");
            listEmployees = (List<Employee>) query.list();
            //            for (Employee el : listEmployees)
            //                System.out.println(el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime());
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }

    public static List<Employee> getListEmployeeByDate(String dateSelect) {
        Session session = null;
        List<Employee> listEmployees = new ArrayList<Employee>();

        try {
            // вывод Employee по точной дате добавления
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where insertTime = '" + dateSelect + "'");
            //query.setParameter("insertTime", dateSelect);
            listEmployees = (List<Employee>) query.list();
            //            for (Employee el : listEmployees)
            //                System.out.println(el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime());
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }

    public static List<Employee> getListEmployeeAfterDate(String dateAfter) {
        Session session = null;
        List<Employee> listEmployees = new ArrayList<Employee>();

        try {
            // вывод Employee добавленные после даты
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where insertTime > '" + dateAfter + "'");
            listEmployees = (List<Employee>) query.list();
            //            for (Employee el : listEmployees)
            //                System.out.println(el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime());
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }

    public static List<Employee> getListEmployeeBetweenDate(String sincePeriod, String tillPeriod) {
        Session session = null;
        List<Employee> listEmployees = new ArrayList<Employee>();

        try {
            // вывод Employee добавленные между датами
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where insertTime > '" + sincePeriod + "' and insertTime < '" + tillPeriod + "'");
            listEmployees = (List<Employee>) query.list();
            //            for (Employee el : listEmployees)
            //                System.out.println(el.getId() + " " + el.getName() + " " + el.getRole() + " " + el.getInsertTime());
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }
}
