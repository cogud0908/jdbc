package com.douzon.jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDao {
	
	public List<EmployeeVo> getList(){
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select emp_no ,concat(first_name, ' ',last_name), hire_date from employees"; 
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int emp_no = rs.getInt(1);
				String name = rs.getString(2);
				String hire_date = rs.getString(3);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setEmp_no(emp_no);
				vo.setName(name);
				vo.setHire_date(hire_date);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;		
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
	
	public boolean selectStatus(String name) {

		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1.JDBC Driver(MySQL) 로딩
			conn = getConnection();
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select emp_no, concat(first_name, ' ',last_name), hire_date from employees where first_name like + '%"+name+"%' or last_name like + '%"+name+"%'";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			String emp_name = "";
			int emp_no;
			String hire_date;
			while (rs.next()) {
				 emp_name = rs.getString(2);
				 emp_no = rs.getInt(1);
				 hire_date = rs.getString(3);
				 
				 System.out.println("["+emp_no +"] "+emp_name + " " + hire_date);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
