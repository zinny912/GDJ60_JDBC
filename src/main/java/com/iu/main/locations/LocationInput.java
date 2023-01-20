package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {
	
	private Scanner sc;
	
	
	public LocationInput() {
		this.sc = new Scanner(System.in);
	
	}
	//수정
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("수정할 Locaiton_id 입력");
		locationDTO.setLocation_id(sc.nextInt());
		System.out.println("수정할 우편번호 입력");
		locationDTO.setPostal_code(sc.next());
		System.out.println("수정할 주소 입력");
		locationDTO.setStreet_address(sc.next());
		
		return locationDTO;
	}
	
	
	
	//추가
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("주소 입력");
		locationDTO.setStreet_address(sc.next());
		System.out.println("우편번호 입력");
		locationDTO.setPostal_code(sc.next());
		System.out.println("도시명 입력");
		locationDTO.setCity(sc.next());
		System.out.println("시군구 입력");
		locationDTO.setState_province(sc.next());
		System.out.println("도시 ID 입력");
		locationDTO.setCountry_id(sc.next());
		
		return locationDTO;
		
	}
		
	//삭제
	public LocationDTO deleteData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("삭제할 Location ID 입력");
		locationDTO.setLocation_id(sc.nextInt());
		
		return locationDTO;
	}

}
