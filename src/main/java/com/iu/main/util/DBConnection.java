package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public void getConnection()throws Exception{
		//1.id
		String username = "hr";
		//2.pw
		String password = "hr";
		//3. url 정보 /IP : Port 번호
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4. driver
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//내가 만든 쿼리문을 보내고,
		String sql ="SELECT * FROM REGIONS WHERE REGION_ID=1";
		
		//DB랑 연결준비를 해주고
		PreparedStatement st = connection.prepareStatement(sql);
		
		// resultset에 보내야함
		ResultSet rs = st.executeQuery();
	
		while(rs.next()) {
			System.out.println(rs.getString("REGION_ID"));
			System.out.println(rs.getString("REGION_NAME"));
//			System.out.println(rs.getInt("REGION_ID"));
//			System.out.println(rs.getString("CITY"));
//			System.out.println(rs.getString("STATE_PROVINCE"));
//			System.out.println(rs.getString("COUNTRY_ID"));
			
			// DB에 있는 각 테이블 명 입력
		}
		
	}

}
