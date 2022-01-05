package javaBasic;


public class Topic_08_For_ForEacch_Excecsice {

		
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
		}
		
	
}
