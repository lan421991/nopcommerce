package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Excecsice {
	String courseName = "1233Automation Testing Advance";
	
	//@Test
	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();
		int countUpper = 0;
		int countLoser = 0;
		int countNumber = 0;
		for (char character : courseNameArr) {
			if (character <= 'Z' && character >= 'A' ) {
			countUpper++;
			}
			
			if (character <= '9' && character >= '0' ) {
				countNumber++;
			}
			
			if (character <= 'z' && character >= 'a' ) {
			countLoser++;
			}
			
		}
		System.out.println("Sum of upperCase =" + countUpper); 
		System.out.println("Sum of countLoser =" + countLoser); 
		System.out.println("Sum of countNumber =" + countNumber); 
	}
	
	//@Test
	public void TC_02() {
		char courseNameArr[] = courseName.toCharArray();
		int count=0;
		for (char c : courseNameArr) {
			if(c == 'a') {
				count++;
			}
		}
		System.out.println(count);

	}
	
	@Test
	public void TC_03() {
		char courseNameArr[] = courseName.toCharArray();
		for (int i = courseNameArr.length - 1; i>=0 ; i--) {
			System.out.println(courseNameArr[i]); 
		}
	}
}
