package com.annotion_crud;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		int flag=1;
		int choice=0;
		do {
			System.out.println("1 : Create");
			System.out.println("2 : Read");
			System.out.println("3 : Update");
			System.out.println("4 : Delete");
			System.out.println("5 : Exit");
			System.out.print("Enter ur choice : ");
			choice = sc.nextInt();
			if(choice==1) {
				System.out.print("Enter the Student Roll : ");
				int id = sc.nextInt();
				System.out.print("Enter the Student Name : ");
				String name = sc.next();
				System.out.print("Enter the Student Gender : ");
				String gen = sc.next();
				student stu = new student(id,name,gen);
				try {
					session.persist(stu);
					System.out.println("Data inserted!!!");
				} catch (Exception e) {
					System.out.println("Student Roll already exits !!!");
				}
			}
			else if(choice==2) {
				System.out.print("Enter the Roll to be read : ");
				int id = sc.nextInt();
				try {
					student dp = session.get(student.class,id);
					System.out.println("Student Roll     : "+dp.getRoll());
					System.out.println("Student Name   : "+dp.getName());
					System.out.println("Student Gender : "+dp.getGender());
					
				} catch (Exception e) {
					System.out.println("Ur Roll doesn't exists!!");
				}
				
			}
			else if(choice ==3) {
				System.out.print("Enter the Roll : ");
				int id = sc.nextInt();
				System.out.print("Enter the New Name : ");
				String new_nameString = sc.next();
				try {
					student dp = session.get(student.class,id);
					dp.setName(new_nameString);
					System.out.println("Data Updated !!!");
				} catch (Exception e) {
					System.out.println("Given Roll doesn't exits ");
				}
				
			}
			else if(choice==4) {
				System.out.print("Enter the Roll to be delete : ");
				int id = sc.nextInt();
				try {
					student dp = session.get(student.class,id);
					session.delete(dp);
					System.out.println("Data deleted !!!");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Given Roll doesn't exits!!!");
				}
			}
			else if(choice==5) {
				flag=0;
				break;
			}
			else {
				System.out.println("Enter a valid input !!!");
			}
		}while(flag==1);
		tx.commit();
		factory.close();
		sc.close();
    }
}
