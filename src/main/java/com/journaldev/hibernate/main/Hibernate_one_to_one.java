package com.journaldev.hibernate.main;


import com.journaldev.hibernate.model.Department;
import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Hibernate_one_to_one {

    public static void main(String[] args) {
        List<Employee> listEmployees = new ArrayList<Employee>();

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();

        try {
            for (int i = 0; i < 250; i++) {
                Employee empl_1 = new Employee();
                empl_1.setName("Denis");
                empl_1.setRole("QAAut" + (new Random()).nextInt());
                empl_1.setInsertTime(new Date());

                Department depart_1 = new Department();
                depart_1.setName("QA_Departament");
                depart_1.setEmployee(empl_1);
                empl_1.setDepartment(depart_1);

                //Save the Model objects
                session.save(empl_1);
                System.out.println("new Employee ID = " + empl_1.getId());
                System.out.println("new Departament ID = " + depart_1.getId());

                Employee empl_2 = new Employee();
                empl_2.setName("Petr");
                empl_2.setRole("Develop");
                empl_2.setInsertTime(new Date());

                Department depart_2 = new Department();
                depart_2.setName("Develop_Departament");
                depart_2.setEmployee(empl_2);
                empl_2.setDepartment(depart_2);

                //Save the Model objects
                session.save(empl_2);
                System.out.println("new Employee ID = " + empl_2.getId());
                System.out.println("new Departament ID = " + depart_2.getId());
            }

            //Commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            System.out.println("вывод всего списка записанных в базу Employee");
            listEmployees = Employee.getListAllEmployee();
            for (Employee el : listEmployees)
                System.out.println(el.toString());

            //terminate session factory, otherwise program won't end
            HibernateUtil.getSessionFactory().close();
        }
    }

}
