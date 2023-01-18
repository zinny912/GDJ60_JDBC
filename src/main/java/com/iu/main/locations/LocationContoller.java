package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationContoller {
	private Scanner sc; //의존성
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationContoller() {
		this.sc=new Scanner(System.in); //의존성 주입
		this.locationDAO=new LocationDAO();
		this.locationView = new LocationView();
	}
	
	public void start() throws Exception{
		boolean check = true;
		ArrayList<LocationDTO> ar = null; // switch-case의 경우 변수 동일명을 사용하면 변수 중복으로 에러가 나오기 때문에 바깥에다가 선언해주기
		
		while(check) {
			System.out.println("1.부서전체정보");
			System.out.println("2.부서상세정보");
			System.out.println("3.");
			System.out.println("4.종   료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.println("부서번호를 입력하세요");
				select = sc.nextInt();
				LocationDTO locationDTO = locationDAO.getDetail(select);
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("부서가 없다");
				}
				break;
			case 3:
				System.out.println("검색할 주소 입력");
				String add = sc.next();
				ar = locationDAO.getFind(add);
				
			default:
				check = false;
				
			}
			
		}
		
		
	}
	
	
	

}
