package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;



public class LocationDAO {
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		Connection connection = DBConnection.getConnection(); // DB연결
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";

		PreparedStatement st = connection.prepareStatement(sql);

		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		
			ar.add(locationDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
		
	}
	
	
	public LocationDTO getDetail(int location_id) throws Exception{
		
		LocationDTO locationDTO=null;
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, location_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
						
		}else {
			System.out.println("데이터가 없다");
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return locationDTO;
		
	}
	
	public ArrayList<LocationDTO> getList() throws Exception{
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		//DBConnection dbConnection = new DBConnection();
		Connection connection = DBConnection.getConnection();
		
		
		//3. Query문 생성
		String sql = "SELECT * FROM LOCATIONS";
		
		//4. Query문 DB로 미리 전송 (미완성)
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? 값 세팅 (option)
		
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		
			ar.add(locationDTO);
					
		}
				
		//7. 연결 해제
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}

}
