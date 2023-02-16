package com.celstra.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celstra.dao.intf.RegistrationDaoIntf;
import com.celstra.pojo.RegistrationEntity;

@Repository
public class RegistrationDaoImpl implements RegistrationDaoIntf {

	@Autowired
	private SessionFactory sessionFactory;

	public String saveuser(RegistrationEntity entity) {
		// TODO Auto-generated method stub
		Session session = null;
		String result = "success";
		try {
			System.out.println("Hii Inside Save User method in DaoImpl");
			session = sessionFactory.getCurrentSession();
			System.out.print("username:::" + entity.getUserName() + ":::password:::" + entity.getPassword()
					+ ":::emailId:::" + entity.getEmailId() + ":::mobileNo:::" + entity.getMobileNo());
			session.saveOrUpdate(entity);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error in login() -->" + ex.getMessage());
			result = "Database Error !Unable to connect database";
		}
		return result;
	}
	@Override
	public List<RegistrationEntity> getUsers(Map<String, Object> map) {
		Session session;
		List<RegistrationEntity> entity;
		session = sessionFactory.openSession();
		entity = session.createQuery("From RegistrationEntity").list();
//		System.out.println(entity);
		return entity;
	}
	
	@Override
	public String delete(RegistrationEntity del)
	{
		Session session = null;
		String result  = "Deleted";
		
		try {
			System.out.println("Hii inside dao delete method");
		      session  = sessionFactory.openSession();
		      Transaction tr=session.beginTransaction();
		      Query query = session.createQuery("DELETE RegistrationEntity WHERE userId = "+del.getUserId());
		      int res = query.executeUpdate();
		      tr.commit();
		}
		catch(Exception e)
		{
			result = "Not Deleted";
			e.printStackTrace(); 
		}
		return result;
	}
	


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
