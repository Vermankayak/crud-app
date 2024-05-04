package com.niharku.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.niharku.dto.Employee;
import com.niharku.util.JdbcUtil;

public class DaoImpl implements IDao{

	@Override
	public String insertEmployee(String id, String name, String dept, int salary, String email) {
		try {
			Connection conn = null;
			PreparedStatement pst = null;
			
			conn = JdbcUtil.getConnection();
			String insertQuery = "insert into employees_tbl (`id`,`name`,`dept`,`salary`,`email`, `created_dt`) values(?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(insertQuery);
			pst.setInt(1, Integer.parseInt(id));
			pst.setString(2, name);
			pst.setString(3, dept);
			pst.setInt(4, salary);
			pst.setString(5, email);
			pst.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
			
			pst.executeUpdate();
			
			JdbcUtil.removeConnection(conn, pst, null);
			return "Successfully inserted record";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee searchEmployee(String id) {
		try {
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			Employee e = new Employee();
			
			conn = JdbcUtil.getConnection();
			String searchQuery = "Select * from employees_tbl where id=?";
			pst = conn.prepareStatement(searchQuery);
			pst.setInt(1, Integer.parseInt(id));
			
			rs = pst.executeQuery();
		
			
			if(rs.next()) {
				e.setId(rs.getInt(1)); ;
				e.setName(rs.getString(2)); ;
				e.setDept(rs.getString(3)); ;
				e.setSalary(rs.getInt(4)); ;
				e.setEmail(rs.getString(5)); ;
				e.setCreatedDate(rs.getTimestamp(6));
			}
			
			JdbcUtil.removeConnection(conn, pst, rs);
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String updateEmployee(String id, String name, String dept, int salary, String email) {
		try {
			Connection conn = null;
			PreparedStatement pst = null;
			
			conn = JdbcUtil.getConnection();
			String updatetQuery = "update employees_tbl set name = ?, dept = ?, salary = ?, email = ?, created_dt = ? where id = ?";
			
			pst = conn.prepareStatement(updatetQuery);
			pst.setString(1, name);
			pst.setString(2, dept);
			pst.setInt(3, salary);
			pst.setString(4, email);
			pst.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
			pst.setInt(6, Integer.parseInt(id));
			pst.executeUpdate();
			
			JdbcUtil.removeConnection(conn, null, null);
			return "Successfully updated record";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String deleteEmployee(String id) {
		try {
			Connection conn = null;
			PreparedStatement pst = null;
			
			conn = JdbcUtil.getConnection();
			
		    String updatetQuery = "delete from employees_tbl where id = ?";
			
			pst = conn.prepareStatement(updatetQuery);
			pst.setInt(1, Integer.parseInt(id));
			pst.executeUpdate();
			JdbcUtil.removeConnection(conn, null, null);
			return "Successfully deleted record";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
