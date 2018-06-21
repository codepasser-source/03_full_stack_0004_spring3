package com.baishui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

 

import com.baishui.dao.UserDao;
import com.baishui.model.User;

@Component(value="userDaoForMySql")
public class UserDaoForMySqlImpl implements UserDao{ 

	private DataSource datasource;
	

	public DataSource getDatasource() {
		return datasource;
	}

	@Resource(name="datasource")
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public void saveUser(User u) {  
		
		String sql = "insert into category(name,descrtiption)" +
				"values(?,?)";
		
		try {
			Connection conn = this.datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getUsername());
			
			ps.executeUpdate(); 
			ps.close();
			conn.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("UserDaoForMySqlImpl user save");
	}

	public void list() {
		// TODO Auto-generated method stub
		
	}
	
	 

}
