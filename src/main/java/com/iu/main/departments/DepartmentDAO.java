package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;


public class DepartmentDAO {
	//update
	public int updateData(DepartmentDTO departmentDTO)throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
				
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	
	
	//delete
	public int deleteData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID =?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
	
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	
	
	//insert
	public int setData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
	
		PreparedStatement st = connection.prepareStatement(sql);
		
		//물음표를 기준으로 3번째
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	
	}
	
	
	public DepartmentDTO getDetail(int department_id) throws Exception{
		Connection connection = DBConnection.getConnection();
		
		DepartmentDTO departmentDTO = null;
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, department_id); //oracle은 1번부터 시작
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
		}else {
			System.out.println("데이터가 없다");
		}
		
		DBConnection.disConnect(rs, st, connection);
		return departmentDTO;
		
	}
	
	public ArrayList<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
				
		//1. 접속 정보 준비
		
		//DBConnection dbConnection = new DBConnection();
		Connection connection =  DBConnection.getConnection();
		
		//3. Query문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
				
		//4. Query문 DB로 미리 전송 (미완성)
		PreparedStatement st = connection.prepareStatement(sql);
				
		//5. ? 값 세팅 (option)
						
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
			ar.add(departmentDTO);
					
		}
				
		//7. 연결 해제
		
		DBConnection.disConnect(rs, st, connection);
	
		return ar;
		
		
	}

}
