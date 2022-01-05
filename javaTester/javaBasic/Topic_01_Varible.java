package javaBasic;

public class Topic_01_Varible {
	
	//hàm khởi tạo không có kiểu trả về, không có tham số, trùng tên class
	public Topic_01_Varible() {
//		String studentName;
	}
	
	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome";//constant
	
	String studentName ="Automation FC";
	
	//trong 1 hàm static muốn 1 biến bên ngoài thì biến đó cũng phải là static
	public static void main(String[] args) {
		System.out.println(studentNumber); 
		System.out.println(statusValue); 
		System.out.println(Topic_01_Varible.BROWSER_NAME); 
		System.out.println(Topic_01_Varible.statusValue); 
		
	//ctrl + shift + / và ctrl + shift + \
	
		  Topic_01_Varible topic_01 = new Topic_01_Varible(); Topic_01_Varible
		  topic_02 = new Topic_01_Varible(); Topic_01_Varible topic_03 = new
		  Topic_01_Varible();
		  
		  System.out.println(topic_01.studentName);
		  System.out.println(topic_02.studentName);
		  System.out.println(topic_03.studentName);
		 
	}
	
	//getter
	//hàm return dùng trong các hàm trả về dữ liệu
	//getCurrentUrl/getTitle/getText/getAttribute/getCssValue/getSize/getLocation/getPosision
	public String getStudentName() {
		return this.studentName;
	}
	
	//setter click/sendkey/forward/refresh/clear/back/select/getUrl
	//action là các hàm set dữ liệu
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
