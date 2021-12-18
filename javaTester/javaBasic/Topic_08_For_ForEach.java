package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach {

		
		//@Test
		public void TC_01_For() {
			String[] cityName = {"Hà Nội", "HCM", "Đà Nẵng"};
		
			for (int i = 0; i < cityName.length; i++) {
				System.out.println(cityName[i]); 
				if(cityName[i].equals("HCM")) {
					System.out.println("yes"); 
					break;
				}
			}
			
			System.out.println("------------------------------"); 
			
			for (String name : cityName) {
				System.out.println(name); 
			}
		}
		
		//@Test
		public void TC_02() {
			String[] cityName = {"Hà Nội", "HCM", "Đà Nẵng", "Khánh Hòa"};
			List<String> cityAddress = new ArrayList<String>();
			cityAddress.add("Sa Pa");
			cityAddress.add("Lào Cai");
			cityAddress.add("Điện Biên");
			System.out.println(cityAddress.size()); 
			
			for (String city : cityName) {
				cityAddress.add(city);
			}
			System.out.println(cityAddress.size()); 

			for (String city : cityAddress) {
				System.out.println(city); 
			}
		}
		
		@Test
		public void TC_01_For() {
			String[] cityName = {"Hà Nội", "HCM", "Đà Nẵng"};
		
			for (int i = 0; i < cityName.length; i++) {
				System.out.println(cityName[i]); 
				if(cityName[i].equals("HCM")) {
					System.out.println("yes"); 
					break;
				}
			}
			
			System.out.println("------------------------------"); 
			
			for (String name : cityName) {
				System.out.println(name); 
			}
		}


}
