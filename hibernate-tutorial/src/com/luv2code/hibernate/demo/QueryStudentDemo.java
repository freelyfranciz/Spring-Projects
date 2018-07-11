package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//  start transaction
			session.beginTransaction();
			
			//query the student
			List<Student> theStudent = session.createQuery("from Student s").list();
			
			//display the student
			displayStudent(theStudent);
			
			
			//query student : last name = Francis
			theStudent = session.createQuery("from Student s where lastName ='Francis'").list();
			
			//display student
			System.out.println("\n\nstudents who have last name of Francis");
			displayStudent(theStudent);
			
			
			//Query student : lastName ='Francis' or firstName='Joy'
			theStudent = session.createQuery("from Student s where s.lastName='Francis' OR s.firstName='Joy'").list();
			
			//display student
			System.out.println("\n\nstudents who have last name of Francis or firstname Joy");
			displayStudent(theStudent);
			
			//email ends with 'gmail.com'
			theStudent = session.createQuery("FROM Student s Where s.email LIKE '%gmail.com'").list();
			
			//display student
			System.out.println("\n\nstudents who have emai ends with 'luv2code.com");
			displayStudent(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		
		finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> theStudent) {
		for(Student tempStudent: theStudent) {
			System.out.println(tempStudent);
		}
	}

}
