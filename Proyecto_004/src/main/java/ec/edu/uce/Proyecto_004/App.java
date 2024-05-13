package ec.edu.uce.Proyecto_004;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Professor;
import models.Student;
import models.Subject;

public class App {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Professor.class);
		configuration.addAnnotatedClass(Subject.class);

		// Create Session Factory and auto-close with try-with-resources.
		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

			Session session = sessionFactory.openSession();

			Student student = new Student();
			student.setId(2);
			student.setName("Antonio");
			student.setLastname("Santander");
			student.setAge(19);

			Professor professor = new Professor();
			professor.setId(1);
			professor.setName("Armando");
			professor.setLastname("Valle");
			professor.setAge(28);

			Subject subject = new Subject();
			subject.setId(10);
			subject.setName("Math");
			subject.setDescription("Materia de sumas y restas");
			subject.setLevel(1);

			session.beginTransaction();
			//session.persist(student);
			subject.setName("Social");
			//session.update(subject);
			//session.persist(professor);
			session.persist(subject);
			session.getTransaction().commit();

		}
	}
}
