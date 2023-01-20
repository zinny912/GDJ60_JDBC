package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.PartialResultException;

import java.sql.Date;



import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	//월급의 평균
	
	public HashMap<String, Double> getAvg() throws Exception {
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT AVG(SALARY)*12+100 AS A, SUM(SALARY) FROM EMPLOYEES ";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		//1. List, Array 
		//ArrayList<Double> ar =
		
		//collection 계열
		//2. DTO (Class), 클래스생성 AVG담을 변수, Sum담을 변수 선언해서  
		//3. Map(Key, Value)
		
		//EmployeeDTO employeeDTO = new EmployeeDTO();
		//employeeDTO.setSalary(rs.getDouble("A"));
		//employeeDTO.setCommission_pct(rs);
		
		map.put("avg", rs.getDouble("A"));
		map.put("sum", rs.getDouble(2));
		
		DBConnection.disConnect(rs, st, connection);
		
		return map;
		
	}
	
	
	
	//수정
	public int updateData(EmployeeDTO employeeDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE EMPLOYEES SET PHONE_NUMBER=?, EMAIL=?, SALARY=?"
				+ "WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getPhone_number());
		st.setString(2, employeeDTO.getEmail());
		st.setDouble(3, employeeDTO.getSalary());
		st.setInt(4, employeeDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	
	
	
	//삭제
	public int deleteData (EmployeeDTO employeeDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID =?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	
	
	
	//추가
	public int setData(EmployeeDTO employeeDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME,"
				+ " LAST_NAME, EMAIL, PHONE_NUMBER, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID, HIRE_DATE)"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEmail());
		st.setString(4, employeeDTO.getPhone_number());
		st.setString(5, employeeDTO.getJob_id());
		st.setDouble(6, employeeDTO.getSalary());
		st.setDouble(7, employeeDTO.getCommission_pct());
		st.setInt(8, employeeDTO.getManager_id());
		st.setInt(9, employeeDTO.getDepartment_id());
		st.setString(10, employeeDTO.getHire_date());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	//method 하나에 query 하나
	
	//사원 검색 (last name)
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception {
		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
																//= ? 위에처럼 연결해주거나	
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, search);
		                // "%"+search+"%"
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			
			ar.add(employeeDTO);
							
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
		
	}
		
	
	//사원한명 전체정보 
	public EmployeeDTO getDetail(int employee_id) throws Exception {
		
		EmployeeDTO employeeDTO = null;
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employee_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO= new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				
		}else {
			System.out.println("그런 사원 없어요");
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
		
	}
		
	
	//사원정보리스트
	public ArrayList<EmployeeDTO> getList() throws Exception {
		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		//1.DB 연결
		Connection connection = DBConnection.getConnection();
		
		//2.Query문 생성
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID"
				+ " FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		//3.미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//4.?세팅
		
		//5.최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		//결과물은 여러개 오기때문에 반복문으로 , 1줄이 DTO 하나랑 대응
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(employeeDTO);
			
		}
		
		//6. 연결해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
		
		
	}

}
