package com.journaldev.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class CriteriaHibernateMain {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Crit");
        emp.setRole("SELLER");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        //session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());

        List<Employee> listEmployees = new ArrayList<Employee>();

        System.out.println("вывод всего списка Employee через Criteria");
        //listEmployees = Employee.getListAllEmployee_Criteria(session);
        //session.beginTransaction();
        Criteria cr = session.createCriteria(Employee.class);
        listEmployees = cr.list();
        for (Employee el : listEmployees)
            System.out.println(el.toString());

        System.out.println("вывод части списка Employee через Pagination using Criteria");
        //cr = session.createCriteria(Employee.class);
        cr.setFirstResult(1);
        cr.setMaxResults(12);
        listEmployees = cr.list();
        for (Employee el : listEmployees)
            System.out.println(el.toString());


        session.getTransaction().commit();



        //        System.out.println("вывод всего списка записанных в базу Employee");
        //        listEmployees = Employee.getListAllEmployee();
        //        for (Employee el : listEmployees)
        //            System.out.println(el.toString());
        //
        //        System.out.println("вывод Employee по имени David");
        //        listEmployees = Employee.getListEmployeeByName("David");
        //        for (Employee el : listEmployees)
        //            System.out.println(el.toString());
        //
        //        System.out.println("вывод Employee по точной дате добавления 2016-11-23");
        //        //Date dateSelect = new GregorianCalendar(2016, 11, 23).getGregorianChange();
        //        //LocalDate specificDate = LocalDate.of(2016, Month.NOVEMBER, 23);
        //        String dateSelect = "2016-11-23";
        //        listEmployees = Employee.getListEmployeeByDate(dateSelect);
        //        for (Employee el : listEmployees)
        //            System.out.println(el.toString());
        //
        //        System.out.println("вывод Employee добавленные после даты 2016-11-23");
        //        String dateAfter = "2016-11-23";
        //        listEmployees = Employee.getListEmployeeAfterDate(dateAfter);
        //        for (Employee el : listEmployees)
        //            System.out.println(el.toString());
        //
        //        System.out.println("вывод Employee добавленные между датами 2016-11-23 и 2016-11-26");
        //        String sincePeriod = "2016-11-23";
        //        String tillPeriod = "2016-11-26";
        //        listEmployees = Employee.getListEmployeeBetweenDate(sincePeriod, tillPeriod);
        //        for (Employee el : listEmployees)
        //            System.out.println(el.toString());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();

    }


}
