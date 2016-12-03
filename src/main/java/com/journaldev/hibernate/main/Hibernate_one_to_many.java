package com.journaldev.hibernate.main;

import com.journaldev.hibernate.model.Department;
import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.model.Nickname;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.cache.spi.NaturalIdCacheKey;

import java.util.*;

public class Hibernate_one_to_many {

    public static void main(String[] args) {
        List<Employee> listEmployees = new ArrayList<Employee>();
        List<Nickname> listNicknames = new ArrayList<Nickname>();

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();

        try {
            for (int i = 0; i < 150; i++) {
                Employee empl_1 = new Employee();
                empl_1.setName("Alexandr");
                empl_1.setRole("WebDev" + (new Random()).nextInt());
                empl_1.setInsertTime(new Date());

                Department depart_1 = new Department();
                depart_1.setName("Web_Departament");
                depart_1.setEmployee(empl_1);

                Nickname nik1_1 = new Nickname();
                nik1_1.setName("Alex1_" + (new Random()).nextInt());
                nik1_1.setEmployee(empl_1);
                Nickname nik1_2 = new Nickname();
                nik1_2.setName("Alex2_" + (new Random()).nextInt());
                nik1_2.setEmployee(empl_1);
                Nickname nik1_3 = new Nickname();
                nik1_3.setName("Alex3_" + (new Random()).nextInt());
                nik1_3.setEmployee(empl_1);
                Set<Nickname> nicknameSet = new HashSet<Nickname>();
                nicknameSet.add(nik1_1);
                nicknameSet.add(nik1_2);
                nicknameSet.add(nik1_3);

                empl_1.setDepartment(depart_1);
                empl_1.setNicknames(nicknameSet);

                //Save the Model objects
                session.save(empl_1);
                session.save(nik1_1);
                session.save(nik1_2);
                session.save(nik1_3);
                System.out.println("new Employee ID = " + empl_1.getId());
                System.out.println("new Departament ID = " + depart_1.getId());
                System.out.println("new Nik1 ID = " + nik1_1.getId());
                System.out.println("new Nik2 ID = " + nik1_2.getId());
                System.out.println("new Nik3 ID = " + nik1_3.getId());

                Employee empl_2 = new Employee();
                empl_2.setName("Vitalyi");
                empl_2.setRole("QAManual");
                empl_2.setInsertTime(new Date());

                Department depart_2 = new Department();
                depart_2.setName("QA_Departament");
                depart_2.setEmployee(empl_2);

                Nickname nik2_1 = new Nickname();
                nik2_1.setName("Vit1_" + (new Random()).nextInt());
                nik2_1.setEmployee(empl_1);
                Nickname nik2_2 = new Nickname();
                nik2_2.setName("Vit2_" + (new Random()).nextInt());
                nik2_2.setEmployee(empl_1);
                Nickname nik2_3 = new Nickname();
                nik2_3.setName("Vit3_" + (new Random()).nextInt());
                nik2_3.setEmployee(empl_1);
                nicknameSet = new HashSet<Nickname>();
                nicknameSet.add(nik2_1);
                nicknameSet.add(nik2_2);
                nicknameSet.add(nik2_3);

                empl_2.setDepartment(depart_2);
                empl_2.setNicknames(nicknameSet);

                //Save the Model objects
                session.save(empl_2);
                session.save(nik2_1);
                session.save(nik2_2);
                session.save(nik2_3);
                System.out.println("new Employee ID = " + empl_2.getId());
                System.out.println("new Departament ID = " + depart_2.getId());
                System.out.println("new Nik1 ID = " + nik2_1.getId());
                System.out.println("new Nik2 ID = " + nik2_2.getId());
                System.out.println("new Nik3 ID = " + nik2_3.getId());
            }

            //Commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            System.out.println("вывод всего списка записанных в базу Employee");
            listEmployees = Employee.getListAllEmployee();
            for (Employee elEmpl : listEmployees)
                System.out.println(elEmpl.toString());

            System.out.println("вывод всего списка записанных в базу Nikname");
            listNicknames = Nickname.getListAllNicknames();
            for (Nickname elNik : listNicknames)
                System.out.println(elNik.toString());

            //            // show all nicknames of Employees
            //           Employee.showAllNicknamesEmployee();


            //terminate session factory, otherwise program won't end
            HibernateUtil.getSessionFactory().close();
        }
    }

}
