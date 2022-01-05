package javaBasic;

//import java.util.ArrayList;
import java.util.Arrays;

public class Topic_11_Array {
	String name;
	int age;
	
	public Topic_11_Array(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public static void main(String[] args) {
		//int number[] = {12,7,5,61,15};
		int[] student = {12,7,5,61,15};
		System.out.println(student[0]); 
		System.out.println(student[1]); 
		System.out.println(student[2]); 
		
		String studentName[] = {"Nam", "long", "an"};
		
		int b[] = new int[5];
		b[0] =10;
		
		for (int i = 0; i < studentName.length; i++) {
			System.out.println(studentName[i]);
			if (studentName[i].equals("long")) {
				System.out.println("click vào long"); 
			}
		}
		
		for (String std : studentName) {
			if (std.equals("long")) {
				System.out.println("click vào long"); 
			}
		}
		
//		ArrayList<String> stdName = new ArrayList<String>();
		for (String std : studentName) {
			if (std.equals("long")) {
				System.out.println("click vào long"); 
			}	
		}
		
		//nhân đôi mảng
//		String newStudentName[] = studentName.clone();
		
		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name); 
		
		
	}
}
