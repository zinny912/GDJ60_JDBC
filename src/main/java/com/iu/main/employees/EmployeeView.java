package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	
	
	//string 출력
	public void view(String msg) {
		System.out.println(msg);
			
	}
	
		
	//개별사원정보 출력
	public void view(EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO.getEmployee_id());
		System.out.println(employeeDTO.getFirst_name());
		System.out.println(employeeDTO.getLast_name());
		System.out.println(employeeDTO.getJob_id());
		System.out.println(employeeDTO.getDepartment_id());
		System.out.println(employeeDTO.getEmail());
		System.out.println(employeeDTO.getPhone_number());
		System.out.println(employeeDTO.getHire_date());
		System.out.println(employeeDTO.getSalary());
		System.out.println(employeeDTO.getCommission_pct());
		
		
		
	}
	
	
	
	//전체사원정보 출력
	public void view(ArrayList<EmployeeDTO> ar) {
		
		for(EmployeeDTO employeeDTO:ar) {
			this.view(employeeDTO);
		}
		
		
		
		
	}

}
