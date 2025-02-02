package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			//start transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId = 2;
			
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			
			//print the instructor detail
			System.out.println("tempInstuctorDetail : " + tempInstructorDetail);
			
			//print associated instructor
			System.out.println("the associated instructor : " 
						+ tempInstructorDetail.getInstructor());
			
			//now lets delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: "
					+ tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}

	}

}
