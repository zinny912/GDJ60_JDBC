package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	
	
	
	//String 출력
	public void view(String msg) {
		System.out.println(msg);
	}
	
	
	
	//부서출력
	public void view(LocationDTO locationDTO) {
		System.out.println(locationDTO.getLocation_id());
		System.out.println(locationDTO.getStreet_address());
		System.out.println(locationDTO.getPostal_code());
		System.out.println(locationDTO.getCity());
		System.out.println(locationDTO.getState_province());
		System.out.println(locationDTO.getCountry_id());
	}
	
	
	
	//전체출력
	public void view(ArrayList<LocationDTO> ar) {
		
		for(LocationDTO locationDTO:ar) {
			this.view(locationDTO);
		}
		
	}

}
