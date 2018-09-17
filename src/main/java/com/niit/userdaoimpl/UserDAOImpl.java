package com.niit.userdaoimpl;
import java.sql.Connection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.userdao.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	Connection con;
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User findUserById(int UserId) {
		return (User)sessionFactory.getCurrentSession().createQuery("from User where UserId="+UserId).uniqueResult();
	}

	public User findUserByName(String UserName) {
		return (User)sessionFactory.getCurrentSession().createQuery("from User where UserName='"+UserName+"'").uniqueResult();
	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	public boolean deleteUser(int UserId) {
		sessionFactory.getCurrentSession().delete(findUserById(UserId));	
		return true;
	}

}

