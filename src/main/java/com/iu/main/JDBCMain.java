package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationContoller;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		FrontController fc = new FrontController();
		
//		DepartmentController dc = new DepartmentController();
//		LocationContoller lc = new LocationContoller();
//		EmployeeController ec = new EmployeeController();
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		LocationDAO locationDAO = new LocationDAO();
		
		try {
						
		//	dc.start();
		//	lc.start();
		//	ec.start();
			fc.start();
			
			
			
			
//			//Location delete Test
//			LocationDTO locationDTO = new LocationDTO();
//			locationDTO.setLocation_id(3300);
//			int result = locationDAO.deleteData(locationDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
						
			
			//Location insert Test
//			LocationDTO locationDTO = new LocationDTO();
//			locationDTO.setLocation_id(3300);
//			locationDTO.setCity("Test");
//			locationDTO.setCountry_id("ZZ");
//			locationDTO.setStreet_address("Test00102039102TT");
//			locationDTO.setPostal_code("Test001");
//			locationDTO.setState_province("SEOUL");
//			int result = locationDAO.setData(locationDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
			
			
			//Department delete Test
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(300);
//			int result = departmentDAO.deleteData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
			
			//Department insert Test
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_name("TestIT");
//			departmentDTO.setManager_id(200);
//			departmentDTO.setLocation_id(1700);
//			int result = departmentDAO.setData(departmentDTO);
//			
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
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
