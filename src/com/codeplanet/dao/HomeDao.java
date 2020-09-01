package com.codeplanet.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codeplanet.model.User;
import com.codeplanet.model.UserLogin;
import com.codeplanet.model.UserRegister;

@Repository
public class HomeDao {
@Autowired
JdbcTemplate jdbcTemplate;
	public String insertInfo(UserRegister user,HttpServletResponse res) throws SQLException, IOException {
		
		
		Connection con=null;  //It set connection
		PrintWriter out=res.getWriter();
		String flag="0";
//		CallableStatement pst =con.prepareCall("call test(?,?,?)");
//		pst.setString(1, "add1");
//		pst.setString(2, "");
//		pst.setInt(3, 0);
		try {
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps=con.prepareStatement("select * from loginpdf where email=?");
			ps.setString(1,user.getEmail());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				flag="1";
			else {
				PreparedStatement pst=con.prepareStatement("insert into loginpdf values(?,?,?,?,?)");
				pst.setString(1,user.getUserName());
				pst.setString(2, user.getName());
				pst.setString(3,user.getEmail());
				pst.setString(4,user.getPassword());
				pst.setInt(5,user.getMobile());
				pst.executeUpdate();
			}	
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally {
			try {
				con.close();
			}
			catch(Exception e)
			{e.printStackTrace();}
		}
		return flag;
		
	}
	
	public String getInfo(UserLogin user,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		System.out.println("dao method"+user.getEmail());
		Connection con=null;
		String s=null;
		try {
			con=jdbcTemplate.getDataSource().getConnection();  //it set connection
			if(user.getEmail()!=null && user.getPassword()!=null) {
				PreparedStatement pst=con.prepareStatement("select * from loginpdf where"+ "email=?"+"and password=?");
				pst.setString(1, user.getEmail());
				pst.setString(2, user.getPassword());
				ResultSet rs=pst.executeQuery();

				while(rs.next())
				{
					out.print("Welcome!"+rs.getString("name"));				}
			}
			else {
				out.print("Enter Email id");
				
			}
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally {
			try {
		con.close();
			}
			catch(Exception e)
			{e.printStackTrace();}
		}
		return s;
		
	}

}
