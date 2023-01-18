package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationContoller;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		DepartmentController dc = new DepartmentController();
		LocationContoller lc = new LocationContoller();
		EmployeeController ec = new EmployeeController();
		
		try {
						
		//	dc.start();
		//	lc.start();
			ec.start();
			
		//	dao.getList();
		//	lao.getList();
		//dao.getDetail(211);	
		//lao.getDetail(1800);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("finish");

	}

}
