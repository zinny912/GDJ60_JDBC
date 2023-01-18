package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO departmentDAO; //의존성이 필요함
	private DepartmentView departmentView;
	
	public DepartmentController() {
		this.sc = new Scanner(System.in);// 의존성 주입
		this.departmentDAO = new DepartmentDAO();
		this.departmentView = new DepartmentView();
	}
		
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서전체정보");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 종	 료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ArrayList<DepartmentDTO> ar = departmentDAO.getList();
				departmentView.view(ar);
				//departmentDAO.getList();
				break;
			case 2:
				System.out.println("부서 번호 입력");
				select = sc.nextInt();
				DepartmentDTO departmentDTO = departmentDAO.getDetail(select);
				if(departmentDTO != null) {
					departmentView.view(departmentDTO);
				}else {
					departmentView.view("Data가 없다"); //오버라이딩 String
				}
				
				break;
			default:
				check = false;
			
			}
		}
	}

}
