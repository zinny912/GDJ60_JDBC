package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
			//getConnection()메서드를 static으로, 클래스 메서드로 생성하여, 다른 DAO에서 객체생성없이 사용 가능하게끔 
	public static Connection getConnection()throws Exception{
				
		// 1). 접속 정보 준비
						
		//1.id
		String username = "hr";
		//2.pw
		String password = "hr";
		//3. url 정보 /IP : Port 번호
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; // ServiceName
		//String url = "jdbc:oracle:thin:@localhost:1521:XEPDB1" - SID
				
		//4. driver -----------------------> 선언 생략가능
		 String driver = "oracle.jdbc.driver.OracleDriver";
		//				ojdbc 의 패키지명 ------. 클래스명
		
		//forName(driver)를 클래스타입으로 쓰겠다 ---> 선언 생략가능
		Class.forName(driver);
		
		// 2). DB 접속 실행
		Connection connection = DriverManager.getConnection(url, username, password);
		//		return 값으로 connection을 지정하여 getConnerction 메서드가 종료되도 사용할 수 있게끔
		return connection;	
		
		

		
		
//		// 3). Query문 생성
//		String sql ="SELECT * FROM REGIONS";
//		
//		// 4). Query문 DB로 미리 전송 (Query문 미완성, 완성되지 않은 query문을 미리 보내놓는것)
//		PreparedStatement st = connection.prepareStatement(sql);
//		
//		// 5). ? 값 세팅(option) result set에 보내야함
//		ResultSet rs = st.executeQuery();
//	
//		// 6). 최종 전송 및 결과 처리
//		while(rs.next()) {
//			System.out.println(rs.getString("REGION_ID"));
//			System.out.println(rs.getString("REGION_NAME"));
////			System.out.println(rs.getInt("REGION_ID"));
////			System.out.println(rs.getString("CITY"));
////			System.out.println(rs.getString("STATE_PROVINCE"));
////			System.out.println(rs.getString("COUNTRY_ID"));
//			
//		// 7). 연결 해제
//			
//			// DB에 있는 각 테이블 명 입력
//		}
//		
	}
	
	public static void disConnect(PreparedStatement st, Connection connection) throws Exception {
	
		st.close();
		connection.close();
		
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection connection)throws Exception {
		rs.close();
		st.close();
		connection.close();
	}

}
