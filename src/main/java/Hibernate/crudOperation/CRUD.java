package Hibernate.crudOperation;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CRUD {
	Scanner sc = new Scanner(System.in);

	public void create(Session session, Student student) {

		Transaction tr = session.beginTransaction();

		System.out.println("Enter Name of the student");
		String name = sc.next();
		student.setName(name);

		System.out.println("Enter Email of the student");
		String email = sc.next();
		student.setEmail(email);

		System.out.println("Enter Roll No of the student");
		int rn = sc.nextInt();
		student.setRollno(rn);

		session.save(student);
		tr.commit();
		System.out.println("Registration Succesful");

	}

	public void ReadById(Session session) {
		System.out.println("Enter Id of the Student");
		int id = sc.nextInt();
		Transaction tr = session.beginTransaction();
		Student std = session.get(Student.class, id);
		if (std != null) {
			System.out.println("Name = " + std.getName());
			System.out.println("Email = " + std.getEmail());
			System.out.println("Roll No = " + std.getRollno());
		} else {
			System.out.println("Student with Id " + id + " is not Available");
		}
		tr.commit();
	}

	public void update(Session session) {
		System.out.println("Enter Id of the student to be updated");
		int id = sc.nextInt();
		Transaction tr = session.beginTransaction();
		Student std = session.get(Student.class, id);
		if (std != null) {
			System.out.println("Enter Updated Name of the student");
			String name = sc.next();
			std.setName(name);

			System.out.println("Enter Updated Email of the student");
			String email = sc.next();
			std.setEmail(email);

			System.out.println("Enter Updated Roll No of the student");
			int rn = sc.nextInt();
			std.setRollno(rn);
			System.out.println("Update Successful");
		} else {
			System.out.println("student with Id " + id + " is not Avaialable");
		}
		tr.commit();

		
	}

	public void deleteById(Session session) {
		System.out.println("Enter Id of the Student");
		int id = sc.nextInt();
		Transaction tr = session.beginTransaction();
		Student std = session.get(Student.class, id);
		if (std != null) {
			session.delete(std);
		} else {
			System.out.println("Student with id " + id + " is not available");
		}
		tr.commit();
		System.out.println("Deleted Successfully");
	}

}
