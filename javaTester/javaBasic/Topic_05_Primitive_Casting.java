package javaBasic;

public class Topic_05_Primitive_Casting {

	public static void main(String[] args) {
		//Ngầm định
		byte bNumber = 126;
		System.out.println(bNumber); 
		
		short sNumber = bNumber;
		System.out.println(sNumber); 
		
		int iNumber = sNumber;
		System.out.println(iNumber); 
		
		long lNumber = iNumber;
		System.out.println(lNumber); 
		
		float fNumber = lNumber;
		System.out.println(fNumber);
		
		double dNumber = fNumber;
		System.out.println(dNumber);
		
		// tường minh (cast)
		double dNumber1 = 654321789;
		System.out.println(dNumber1); 
		
		float fNumber1 = (float) dNumber1;
		System.out.println(fNumber1); 
		
		long lNumber1 =  (long) fNumber1;
		System.out.println(lNumber1); 
		
		int iNumber1 =  (int) lNumber1;
		System.out.println(iNumber1); 
		
	}

}
