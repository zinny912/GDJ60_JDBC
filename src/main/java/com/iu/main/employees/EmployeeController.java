package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;

	public EmployeeController() {
		this.sc = new Scanner(System.in);
		
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		ArrayList<EmployeeDTO> ar = null;
		
		while(check) {
			System.out.println("1. 사원정보리스트");
			System.out.println("2. 개별 사원정보");
			System.out.println("3. 사 원 검 색");
			System.out.println("4. 종     료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("사원번호를 입력하세요");
				select = sc.nextInt();
				EmployeeDTO employeeDTO = employeeDAO.getDetail(select);
				if(employeeDTO != null) {
					employeeView.view(employeeDTO);
				}else {
					employeeView.view("그런사원없어요");
				}
				break;
			case 3:
				System.out.println("사원이름(Last_Name)을 입력하세요");
				String add = sc.next();
				ar = employeeDAO.getFind(add);
				break;
			default:
				check=false;
				
				
			}
			
		}
		
		
		
	}
}
