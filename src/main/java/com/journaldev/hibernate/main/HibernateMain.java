package com.journaldev.hibernate.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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
		System.out.println("Employee ID="+emp.getId());

		// вывод всего списка записанных в базу Employee
		Employee.getListEmployee();

		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();

	}


}
