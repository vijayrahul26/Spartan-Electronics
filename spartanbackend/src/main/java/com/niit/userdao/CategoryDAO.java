
package com.niit.userdao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO {

	public List<Category> findAllCategory();
	public Category findCategoryById(int Id);
	public Category findCategoryByName(String CategoryName);
	public boolean addCategory(Category Category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int CategoryId);
	
}
