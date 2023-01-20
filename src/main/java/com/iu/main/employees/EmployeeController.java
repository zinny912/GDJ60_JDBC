package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private EmployeeInput employeeInput;

	public EmployeeController() {
		this.sc = new Scanner(System.in);
		this.employeeDAO=new EmployeeDAO();
		this.employeeView= new EmployeeView();
		this.employeeInput= new EmployeeInput();
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		ArrayList<EmployeeDTO> ar = null;
		EmployeeDTO employeeDTO = null;
		while(check) {
			System.out.println("1. 사원정보리스트");
			System.out.println("2. 개별 사원정보");
			System.out.println("3. 사 원 검 색");
			System.out.println("4. 사 원 추 가");
			System.out.println("5. 사 원 삭 제");
			System.out.println("6. 사원정보 수정");
			System.out.println("7. 종     료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("사원번호를 입력하세요");
				select = sc.nextInt();
				employeeDTO = employeeDAO.getDetail(select);
				if(employeeDTO != null) {
					employeeView.view(employeeDTO);
				}
				break;
			case 3:
				System.out.println("사원이름(Last_Name)을 입력하세요");
				String add = sc.next();
				
				ar = employeeDAO.getFind(add);
				if(ar.size()>0) {
					employeeView.view(ar);
				}else {
					System.out.println("그런사람없어요");
				}
				break;
			case 4:
				employeeDTO= employeeInput.setData();
				select = employeeDAO.setData(employeeDTO);
				if(select>0) {
					employeeView.view("추가성공");
				}else {
					employeeView.view("추가실패");
				}
				break;
			case 5:
				employeeDTO=employeeInput.deleteData();
				select = employeeDAO.deleteData(employeeDTO);
				String msg="추가실패";
				if(select>0) {
					msg = "추가성공";
				}
				employeeView.view(msg);
				break;
			case 6:
				employeeDTO= employeeInput.updateData();
				select = employeeDAO.updateData(employeeDTO);
				if(select>0) {
					employeeView.view("삭제성공");
				}else {
					employeeView.view("삭제실패");
				}
				break;
			default:
				check=false;
				
				
			}
			
		}
		
		
		
	}
}
