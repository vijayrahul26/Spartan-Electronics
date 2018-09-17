package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.model.Category;
import com.niit.userdao.CategoryDAO;

import junit.framework.TestCase;

public class CategoryDAOImpltest extends TestCase 
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	
	public void testFindAllCategories() 
	{
		List<Category> categoryList=categoryDAO.findAllCategory();
		assertNotNull(categoryList);
	}

	public void testFindCategoryById() 
	{
		Category category1=categoryDAO.findCategoryById(101);
		assertNotNull(category1);
		int  expectedId=101;
		int actualId=category1.getCategoryId();
		assertTrue(expectedId==actualId);
	}

	public void testFindCategoryByName() 
	{
		Category category2=categoryDAO.findCategoryByName("sandisk");
		assertNotNull(category2);
		String expectedName="sandisk";
		String actualName=category2.getCategoryName();
		assertTrue(expectedName.equals(actualName));
	}

	public void testAddCategory()
	{
		Category category=new Category();
		category.setCategoryId(272);
		category.setCategoryName("guns");
		category.setParentCategory("metal");
		assertEquals(true,categoryDAO.addCategory(category));
	}

	public void testUpdateCategory()
	 {
		Category category3=categoryDAO.findCategoryById(270);
		category3.setParentCategory("watch");
		categoryDAO.updateCategory(category3);
		assertTrue(category3.getParentCategory()=="watch");
	 }

	public void testDeleteCategory() 
	{
		Category category4=categoryDAO.findCategoryById(271);
		assertEquals(true,categoryDAO.deleteCategory(category4.getCategoryId()));
	}

}
