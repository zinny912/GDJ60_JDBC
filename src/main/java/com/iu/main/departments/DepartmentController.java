package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO departmentDAO; //의존성이 필요함
	private DepartmentView departmentView;
	private DepartmentInput departmentInput;
	
	public DepartmentController() {
		this.sc = new Scanner(System.in);// 의존성 주입
		this.departmentDAO = new DepartmentDAO();
		this.departmentView = new DepartmentView();
		this.departmentInput = new DepartmentInput();
	}
		
	public void start() throws Exception {
		boolean check = true;
		DepartmentDTO departmentDTO = null;
		ArrayList<DepartmentDTO> ar = null;
		while(check) {
			System.out.println("1. 부서전체정보");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 부서  추가");
			System.out.println("4. 부서  삭제");
			System.out.println("5. 부서  수정");
			System.out.println("6. 종	료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar = departmentDAO.getList();
				departmentView.view(ar);
				//departmentDAO.getList();
				break;
	
			case 2:
				System.out.println("부서 번호 입력");
				select = sc.nextInt();
				departmentDTO = departmentDAO.getDetail(select);
				if(departmentDTO != null) {
					departmentView.view(departmentDTO);
				}else {
					departmentView.view("Data가 없다"); //오버라이딩 String
				}
				break;
	
			case 3:
				departmentDTO = departmentInput.setData();
				select = departmentDAO.setData(departmentDTO);
				
				if(select>0) {
					departmentView.view("추가성공");
				}else {
					departmentView.view("추가실패");
				}
				break;
	
			case 4:
				departmentDTO = departmentInput.deleteData();
				select = departmentDAO.deleteData(departmentDTO);
				String msg = "삭제 실패";
				
				if(select>0) {
					msg = "삭제 성공";
				}
				departmentView.view(msg);
				break;
	
			case 5:
				departmentDTO = departmentInput.updateData();
				select = departmentDAO.updateData(departmentDTO);
				
				if(select>0) {
					departmentView.view("수정 성공");
				}else {
					departmentView.view("수정 실패");
				}
				break;
			
			default:
				check = false;
			
			}
		}
	}

}
