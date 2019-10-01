/*package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.model.User;
import com.niit.userdao.UserDAO;

import junit.framework.TestCase;

public class UserDAOImpltest extends TestCase
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
  	 UserDAO userDAO = (UserDAO) context.getBean("userDAO");
  	 
	public void testFindAllUsers() {
		List<User> userList=userDAO.findAllUsers();
		assertNotNull(userList);
	}

	public void testFindUserById() {
		User user1=userDAO.findUserById(261);
		assertNotNull(user1);
		int expectedId=261;
	//	int actualId=user1.getUserId();
		assertTrue(expectedId==actualId);
	}

	public void testFindUserByName() {
		User user2=userDAO.findUserByName("vj");
		assertNotNull(user2);
		String expectedName="vj";
		String actualName=user2.getUserName();
		assertTrue(expectedName.equals(actualName));
	}

	public void testAddUser() {
		User user=new User();
		user.setUserName("gbfg");
		user.setUserId(26);
		user.setMobileNumber("945362");
	    user.setEmail("surf@gmail.com");
		user.setPassword("au");
		assertEquals(true,userDAO.addUser(user));
	}

	public void testUpdateUser() {
		User user3=userDAO.findUserById(265);
		user3.setUserId(265);
		user3.setUserName("vs");
		userDAO.updateUser(user3);
		assertTrue(user3.getUserId()==265);
	}

	public void testDeleteUser() {
		User user4=userDAO.findUserById(268);
		assertEquals(true,userDAO.deleteUser(user4.getUserId()));
	}

}

*/