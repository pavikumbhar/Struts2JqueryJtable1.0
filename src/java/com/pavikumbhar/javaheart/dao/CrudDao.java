package com.pavikumbhar.javaheart.dao;



import com.pavikumbhar.javaheart.model.Student;
import com.pavikumbhar.javaheart.util.HibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
;

public class CrudDao {
	
public void saveStudent(Student student){
		
		
		try {
			Session session=HibernateUtil.getSessionfactory().getCurrentSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void updateStudent(Student student){
		
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			session.update(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		session.getTransaction().rollback();
		}
		
		
	}
	
	
	/**
	 * Used to delete a .
	 */
	public void deleteStudent(Integer studId) {
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Student distributor = (Student) session.get(Student.class, studId);
			session.delete(distributor);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} 
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Student> studentList() {
		
		List<Student> studentList = null;
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			studentList = session.createQuery("from Student").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return studentList;
	}
	
	public Student getStudentById(Integer studId)
	  { 
		Student student=null;
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			session.beginTransaction();
			student = (Student) session.get(Student.class, studId);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		
		return student;
	  }
	
	public Integer getCountOfRecord()
	{
		Long size=null;
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			 session.getTransaction().begin();
			  Query query=session.createQuery("select count(*) from Student");
			  size=(Long) query.uniqueResult();
			  session.getTransaction().commit();
		} catch (Exception e) {
			
			session.getTransaction().rollback();
		}
		return size.intValue();
	}
	
	public List<Student> paging(Integer pageNumber, Integer perPage )
	{
		List<Student> students=null;
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			  session.getTransaction().begin();
			  Query query=session.createQuery("from Student");
			  query.setMaxResults(perPage);
	          query.setFirstResult(pageNumber);
	          students = query.list();
			  session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}
		
		
		return students;
		
	}
	
        
        public List<Student> pagingLike(String name)
	{
		List<Student> students=null;
		Session session=HibernateUtil.getSessionfactory().getCurrentSession();
		try {
			  session.getTransaction().begin();
			  Query query=session.createQuery("from Student where name like :name");
                          query.setParameter("name", "%"+name);
			
	          students = query.list();
	         session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}
		
		
		return students;
		
	}
	

	

}
