package in.javahome.orm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.javahome.orm.entity.Student;

public class SaveStudent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("javahome-orm.xml");
		StudentDAO dao = context.getBean(StudentDAO.class);
		
		Student s1 = new Student();
		s1.setName("hari");
		s1.setMail("hari@javahome.in");
		dao.addStudent(s1);
	}
}
