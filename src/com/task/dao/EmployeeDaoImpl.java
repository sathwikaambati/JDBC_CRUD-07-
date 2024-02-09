package com.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.task.bean.EmployeeBean;
import com.task.util.DBUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	public static PreparedStatement pst = null;

	@Override
	public void insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		int empId = bean.getEmpid();
		String empName = bean.getEmpname();
		String empAddress = bean.getEmpaddress();
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pst = connection.prepareStatement("insert into emp values(?,?,?)");

		pst.setInt(1, empId);
		pst.setString(2, empName);
		pst.setString(3, empAddress);
		pst.executeUpdate();
		System.out.println("inserted one record successfully");

	}

	@Override
	public void updateEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pst = connection.prepareStatement("update  emp set empname='kanna' where empid=104");
		pst.executeUpdate();
		System.out.println("updated one record successfully");

	}

	@Override
	public void selectEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pst = connection.prepareStatement("select * from emp");

		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
		System.out.println(" selected successfully");

	}

	@Override
	public void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pst = connection.prepareStatement("delete from emp where empid=104");
		pst.executeUpdate();
		System.out.println("deleted one record successfully");
	}

}
