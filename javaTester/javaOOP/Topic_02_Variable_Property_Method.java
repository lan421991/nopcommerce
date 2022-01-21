package javaOOP;

public class Topic_02_Variable_Property_Method {
	//biến static không phải final nên có thể gán lại giá trị
	//có thể truy cập trực tiếp trong các hàm static
	//có thể gọi trực tiêp từ class khác thông qua tên: tenclass.tenbien
	public static String studentName = "AB";
	
	//dùng trong tất cả các instance/object trong class thông qua tên: tenclass.tenbien
	private static String studentPhone = "AB";
	
	//final không cho phép gán lại dữ liệu
	final String country = "VN";
	
	// hằng số
	//không ghi đè
	// có thể sử dụng rộng rãi cho tất cả các instance/thread
	static final float PI_Number = 3.14f;
	
	// 1 hàm static gọi trực tiếp biến static
	//muốn gọi biến non-static phải thông qua 1 đối tượng
	//biến local phải khởi tạo mới có giá trị
	// biến global có giá trị mặc định
	public static void main(String[] args) {
		studentPhone = "098555555";
		studentName = "Hoa";
		//country = "hoa";
	}
}
