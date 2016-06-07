package in.javahome.orm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.javahome.orm.entity.Student;

@Component
public class StudentDAO {
	@Autowired
	private HibernateTemplate template;
	@Transactional
	public void addStudent(Student std) {
        template.save(std);
	}
	
	@Transactional
	public void delete(Integer stdId){
		Student std = template.get(Student.class, stdId);
		template.delete(std);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public Student findByPrimaryKey(Integer id){
		return template.get(Student.class, id);
	}
	
	@Transactional(rollbackFor={SQLException.class,NullPointerException.class},
			timeout=1)
	public void updateStudent(Student std) {
        template.update(std);
	}
	
	public List<Student> findAll(){
		DetachedCriteria crit = DetachedCriteria.forClass(Student.class);
		return (List<Student>) template.findByCriteria(crit);
	}
	
}
