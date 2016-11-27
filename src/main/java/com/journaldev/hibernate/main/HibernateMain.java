package com.journaldev.hibernate.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateMain {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());

        System.out.println("вывод всего списка записанных в базу Employee");
        List<Employee> listEmployees = Employee.getListAllEmployee();
        for (Employee el : listEmployees)
            System.out.println(el.toString());

        System.out.println("вывод Employee по имени David");
        listEmployees = Employee.getListEmployeeByName("David");
        for (Employee el : listEmployees)
            System.out.println(el.toString());

        System.out.println("вывод Employee по точной дате добавления 2016-11-23");
        //Date dateSelect = new GregorianCalendar(2016, 11, 23).getGregorianChange();
        //LocalDate specificDate = LocalDate.of(2016, Month.NOVEMBER, 23);
        String dateSelect = "2016-11-23";
        listEmployees = Employee.getListEmployeeByDate(dateSelect);
        for (Employee el : listEmployees)
            System.out.println(el.toString());

        System.out.println("вывод Employee добавленные после даты 2016-11-23");
        String dateAfter = "2016-11-23";
        listEmployees = Employee.getListEmployeeAfterDate(dateAfter);
        for (Employee el : listEmployees)
            System.out.println(el.toString());

        System.out.println("вывод Employee добавленные между датами 2016-11-23 и 2016-11-26");
        String sincePeriod = "2016-11-23";
        String tillPeriod = "2016-11-26";
        listEmployees = Employee.getListEmployeeBetweenDate(sincePeriod, tillPeriod);
        for (Employee el : listEmployees)
            System.out.println(el.toString());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();

    }


}
