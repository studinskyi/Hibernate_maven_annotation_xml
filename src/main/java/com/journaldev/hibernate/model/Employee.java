package com.journaldev.hibernate.model;

import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Employee {

    private int id;
    private String name;
    private String role;
    private Date insertTime;
    private Department department;
    private Set<Nickname> nicknames;

    public Set<Nickname> getNicknames() {
        return nicknames;
    }

    public void setNicknames(Set<Nickname> nicknames) {
        this.nicknames = nicknames;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        String strEmployee = "Employee: " + id + " " + name + " " + role + " " + insertTime + " " + department.toString();
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
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }

    public static void showAllNicknamesEmployee() {
        Session session = null;
        List<Object> listNikEmpl = new ArrayList<Object>();

        try {
            // вывод всего списка записанных в базу Employee
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("SELECT OBJECT(rrr) FROM Nickname AS N JOIN N.employee rrr");
            listNikEmpl = (List<Object>) query.list();
            for (Object strNikEmpl : listNikEmpl)
                System.out.println(strNikEmpl.toString());

            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        //return listEmployees;
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
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listEmployees;
    }

    public static List<Employee> getListAllEmployee_Criteria(Session session) {
        List<Employee> listEmployees = new ArrayList<Employee>();

        Transaction tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Employee.class);
        listEmployees = cr.list();
        tx.commit();


        return listEmployees;

    }
}
