package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationContoller {
	private Scanner sc; //의존성
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	
	public LocationContoller() {
		this.sc=new Scanner(System.in); //의존성 주입
		this.locationDAO=new LocationDAO();
		this.locationView = new LocationView();
		this.locationInput = new LocationInput();
	}
	
	public void start() throws Exception{
		boolean check = true;
		ArrayList<LocationDTO> ar = null; // switch-case의 경우 변수 동일명을 사용하면 변수 중복으로 에러가 나오기 때문에 바깥에다가 선언해주기
		LocationDTO locationDTO = null;
		while(check) {
			System.out.println("1.회사소재지 전체정보");
			System.out.println("2.회사소재지 상세정보");
			System.out.println("3.회사소재지 추  가");
			System.out.println("4.회사소재지 삭  제");
			System.out.println("5.회사소재지 수  정");
			System.out.println("6.종         료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.println("소재지 번호를 입력하세요");
				select = sc.nextInt();
				locationDTO = locationDAO.getDetail(select);
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("그런 곳 없다");
				}
				break;
			case 3:
				locationDTO = locationInput.setData();
				select = locationDAO.setData(locationDTO);
				if(select>0) {
					locationView.view("추가성공");
				}else {
					locationView.view("추가실패");
				}
				break;
			case 4:
				locationDTO=locationInput.deleteData();
				select = locationDAO.deleteData(locationDTO);
				String msg = "삭제실패";
				if(select>0) {
					msg = "삭제성공";
				}
				locationView.view(msg);
				break;
			case 5:
				locationDTO = locationInput.updateData();
				select = locationDAO.updateData(locationDTO);
				if(select>0) {
					locationView.view("수정성공");
				}else {
					locationView.view("수정실패");
				}
				break;
			default:
				check = false;
				
			}
			
		}
		
		
	}
	
	
	

}
