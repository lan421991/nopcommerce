package javaBasic;

public class Topic_05_Reference_Casting {
	
	public String studentName;

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student Name =" + studentName); 
	}
	
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Nguyen Van Nam");
		secondStudent.setStudentName("Nguyen Van Dung");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		firstStudent = secondStudent;
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("Le Văn Hung");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		 
	}


}
