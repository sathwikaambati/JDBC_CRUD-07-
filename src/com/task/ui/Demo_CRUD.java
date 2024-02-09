package com.task.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.task.bean.EmployeeBean;
import com.task.service.EmployeeServiceImpl;

public class Demo_CRUD {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("select your option");
		System.out.println("1.insert employee data");// create
		System.out.println("2.update employee dat");// update
		System.out.println("3.select employee data");// read
		System.out.println("4 delete employee data");// delete
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			insertEmployee();
			break;
		}
		case 2: {
			updateEmployee();
			break;
		}
		case 3: {
			selectEmployee();
			break;
		}
		case 4: {
			deleteEmployee();
			break;
		}
		default: {
			System.out.println("your entered option is not match");
		}
		}
	}


	private static void insertEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpid(101);
		bean.setEmpname("sathvika");
		bean.setEmpaddress("hyd");
		service.insertEmployee(bean);
	}

	private static void updateEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		service.updateEmployee(bean);

	}
	
	private static void selectEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		service.selectEmployee(bean);

	}

	private static void deleteEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		service.deleteEmployee(bean);

	}

}
