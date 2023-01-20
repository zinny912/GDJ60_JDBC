package com.iu.main;

import java.util.Scanner;

import com.iu.main.departments.DepartmentController;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationContoller;

public class FrontController {
	
	private Scanner sc;
	private DepartmentController departmentController; //부서관리
	private LocationContoller locationContoller; //지역관리
	private EmployeeController employeeController; //직원관리
	
	
	
	public FrontController() {
		this.sc = new Scanner(System.in);
		this.departmentController = new DepartmentController();
		this.locationContoller = new LocationContoller();
		this.employeeController = new EmployeeController();
	}
	
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서 관리");
			System.out.println("2. 지역 관리");
			System.out.println("3. 사원 관리");
			System.out.println("4. 종    료");
			
			int select = sc.nextInt();
				
			switch(select) {
			case 1:
				this.departmentController.start();
				break;
			case 2:
				this.locationContoller.start();
				break;
			case 3:
				this.employeeController.start();
				break;
			default:
				check = false;
			}
		
		}	
		
	}
	
	

}
