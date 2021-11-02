/**
 * 
 */
package com.crudo.dao;

import java.util.ArrayList;

import com.crudo.bo.Todo;

/**
	author: Vicky pl
	email: vicky542011@gmail.com
	mobile: 7828789845
 **/
/**
 * @author Anonymox
 *
 */
public interface TodoDao {
	
	public abstract boolean addTodo(int userId, String title, String details, String priority, String status);
	
	public abstract boolean deleteTodo(String sql);
	
	public abstract boolean updateTodo(int todoId, String title, String details, String priority, String status);

	public abstract Todo getTodo(String sql);
	
	public abstract ArrayList<Todo> getTodoList(String sql);
}
