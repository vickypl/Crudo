/**
 * 
 */
package com.crudo.dao.implemention;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.crudo.bo.Todo;
import com.crudo.dao.TodoDao;
import com.crudo.utility.DatabaseConnector;

/**
	author: Vicky pl
	email: vicky542011@gmail.com
	mobile: 7828789845
 **/
/**
 * @author Anonymox
 *
 */
public class TodoDaoImplementation implements TodoDao {

	String servletname = this.getClass().getName();
	DatabaseConnector db = new DatabaseConnector();
	Connection connection = null;
	PreparedStatement pstat = null;
	Statement statement = null;
	ResultSet resultSet = null;
	/* (non-Javadoc)
	 * @see com.crudo.dao.TodoDao#addTodo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addTodo(int userId, String title, String details, String priority, String status) {
		boolean stat= false;
		try {
			connection = db.getConnect();
			String sql = "insert into todolist (id, userid, title, details, addedon, priority, status) values(todo_id.nextval, ?, ?, ?, SYSDATE, ?, ?)";
			pstat = connection.prepareStatement(sql);
			pstat.setInt(1, userId);
			pstat.setString(2, title);
			pstat.setString(3, details);
			pstat.setString(4, priority);
			pstat.setString(5, status);
			
			int result = pstat.executeUpdate();
			
			if(result>0) {
				stat = true;
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return stat;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.TodoDao#deleteTodo(java.lang.String)
	 */
	@Override
	public boolean deleteTodo(String sql) {
		boolean status= false;
		try {
			connection = db.getConnect();
			statement = connection.createStatement();
			
			int result = statement.executeUpdate(sql);
			
			if(result>0) {
				status = true;
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return status;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.TodoDao#updateTodo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateTodo(int todoId, String title, String details, String priority, String status) {
		boolean stat= false;
		try {
			connection = db.getConnect();
			String sql="update todolist set title=?, details=?, priority=?, status=? where id=?";
			pstat = connection.prepareStatement(sql);
			pstat.setString(1, title);
			pstat.setString(2, details);
			pstat.setString(3, priority);
			pstat.setString(4, status);
			pstat.setInt(5, todoId);
			int result = pstat.executeUpdate();
			
			if(result>0) {
				stat = true;
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return stat;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.TodoDao#getTodo(java.lang.String)
	 */
	@Override
	public Todo getTodo(String sql) {
		Todo todo = null;
		try {
			connection = db.getConnect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				todo = new Todo();
				todo.setId(resultSet.getString(1));
				todo.setUserId(resultSet.getString(2));
				todo.setTitle(resultSet.getString(3));
				todo.setDetails(resultSet.getString(4));
				todo.setAddedOn(resultSet.getString(5));
				todo.setPriority(resultSet.getString(6));
				todo.setStatus(resultSet.getString(7));
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return todo;
	}

	/* (non-Javadoc)
	 * @see com.crudo.dao.TodoDao#getTodoList(java.lang.String)
	 */
	@Override
	public ArrayList<Todo> getTodoList(String sql) {
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		try {
			connection = db.getConnect();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			Todo todo = null;
			while(resultSet.next()) {
				todo = new Todo();
				todo.setId(resultSet.getString(1));
				todo.setUserId(resultSet.getString(2));
				todo.setTitle(resultSet.getString(3));
				todo.setDetails(resultSet.getString(4));
				todo.setAddedOn(resultSet.getString(5));
				todo.setPriority(resultSet.getString(6));
				todo.setStatus(resultSet.getString(7));
				todoList.add(todo);
			}
			
		} catch (SQLException e) {
			db.logToFile(e, servletname);
		} catch (Exception e) {
			db.logToFile(e, servletname);
		}
		return todoList;
	}

}
