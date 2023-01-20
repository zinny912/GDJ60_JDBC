package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	
	private Scanner sc;
	
	
	public EmployeeInput() {
		this.sc = new Scanner(System.in);
	}
	
	//수정
	public EmployeeDTO updateData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("수정할 사원 번호 입력");
		employeeDTO.setEmployee_id(sc.nextInt());
		System.out.println("수정할 휴대전화번호 입력");
		employeeDTO.setPhone_number(sc.next());
		System.out.println("수정할 이메일 입력");
		employeeDTO.setEmail(sc.next());
		System.out.println("수정할 급여 입력");
		employeeDTO.setSalary(sc.nextDouble());
		
		return employeeDTO;
		
		
	}
	
	
	//추가
	public EmployeeDTO setData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("추가할 사원 성 입력");
		employeeDTO.setFirst_name(sc.next());
		System.out.println("추가할 사원 이름 입력");
		employeeDTO.setLast_name(sc.next());
		System.out.println("추가할 사원 이메일 입력");
		employeeDTO.setEmail(sc.next());
		System.out.println("추가할 사원 휴대전화번호 입력");
		employeeDTO.setPhone_number(sc.next());
		System.out.println("추가할 사원 Job_id 입력");
		employeeDTO.setJob_id(sc.next());
		System.out.println("추가할 사원 월급 입력");
		employeeDTO.setSalary(sc.nextDouble());
		System.out.println("추가할 사원 commission_pct 입력");
		employeeDTO.setCommission_pct(sc.nextDouble());
		System.out.println("추가할 사원 상사ID 입력");
		employeeDTO.setManager_id(sc.nextInt());
		System.out.println("추가할 사원 부서 ID 입력");
		employeeDTO.setDepartment_id(sc.nextInt());
		System.out.println("추가할 사원 입사일 입력");
		employeeDTO.setHire_date(sc.next());
		
		return employeeDTO;
		
	}
	
	
	//삭제
	public EmployeeDTO deleteData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("삭세할 사원 ID 입력");
		employeeDTO.setEmployee_id(sc.nextInt());
		
		return employeeDTO;
				
			
	}
	

}
