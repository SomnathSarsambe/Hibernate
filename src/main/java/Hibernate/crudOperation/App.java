package Hibernate.crudOperation;

import java.util.Scanner;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Student student = new Student();
		while(true) {
		System.out.println("1 ===> To Create user");
		System.out.println("2 ===> To get user by id");
		System.out.println("3 ===> To update user");
		System.out.println("4 ===> To delete user");
		System.out.println("5 ===> To Exit");
		Scanner scan = new Scanner(System.in);
		CRUD cr = new CRUD();
		int n = scan.nextInt();
		
		switch(n) 
		{
		case 1:
			cr.create(session,student);
			break;
			
		case 2:
			cr.ReadById(session);
			break;
			
		case 3:
			cr.update(session);
			break;
		
		case 4:
			cr.deleteById(session);
			break;
			
		case 5:
			System.exit(0);
		}
		session.close();	
		}
		
	}
}
