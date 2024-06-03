package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.entity.User;
import com.org.helper.ConnectionHelper;

public class UserDao {

	public boolean registerUser(User u) {
		
		
		try {
			
			Connection con = ConnectionHelper.getConObj();
			
			String sql="INSERT INTO user(fullname , email , password) VALUES(? , ? , ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getFullname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int res=ps.executeUpdate();
			if(res==1) {
			return	true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public User logIn(String email,String password)
	{
		User u=null;
		try {
		Connection con= ConnectionHelper.getConObj();
		String sql="SELECT * FROM user WHERE email =? AND password =?";
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setFullname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
	
}
