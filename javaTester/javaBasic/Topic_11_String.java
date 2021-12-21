package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_11_String {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\browserDrivers\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		//WebDriver driver = new FirefoxDriver();
		
		String schoolName ="Automation Testing";
		String courseName = schoolName.toLowerCase();
		String schoolAddress ="Ho Chi Minh City";
		
		System.out.println("Độ dài của chuỗi = " + schoolName.length()); 
		
		System.out.println("Lấy ra  kí tự = " + schoolName.charAt(0)); 
		
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);
		
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối= " + schoolName.equals(schoolAddress));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối= " + schoolName.equals("Automation Testing"));
		
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối= " + schoolName.equalsIgnoreCase(courseName));
		
		System.out.println("Có bắt đầu bằng chuỗi kí tự T = " + schoolName.startsWith("T")); 
		System.out.println("Có bắt đầu bằng chuỗi kí tự A = " + schoolName.startsWith("A")); 
		System.out.println("Có bắt đầu bằng chuỗi kí tự Automation = " + schoolName.startsWith("Automation")); 
		
		System.out.println("Có chứa chuỗi kí tự Testing = " + schoolName.contains("Testing")); 
		
		System.out.println("Có kết thúc bằng chuỗi kí tự g = " + schoolName.endsWith("g")); 
		System.out.println("Có kết thúc bằng chuỗi kí tự f = " + schoolName.endsWith("f")); 
		System.out.println("Có kết thúc bằng chuỗi kí tự Testing = " + schoolName.endsWith("Testing")); 
		
		System.out.println("Vị trí của 1 kí tự/chuỗi trong chuỗi = " + schoolName.indexOf("utomation")); 
		System.out.println("Vị trí của 1 kí tự/chuỗi trong chuỗi = " + schoolName.indexOf("Automation")); 
		System.out.println("Vị trí của 1 kí tự/chuỗi trong chuỗi = " + schoolName.indexOf("A")); 
		System.out.println("Vị trí của 1 kí tự/chuỗi trong chuỗi = " + schoolName.indexOf("Testing")); 
		
		System.out.println("Tách 1 kí tư/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11)); 
		System.out.println("Tách 1 kí tư/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11,15)); 
		
		//split: tách chuỗi thàng mảng dựa vào chuỗi hoặc kí tự
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");
		System.out.println(results[1]);
		
		//Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice); 
		
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		
		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice); 
		
//		String osName = System.getProperty("os.name");
//		System.out.println(osName); 
//		
//		String driverInstanceName = driver.toString();
//		System.out.println(driverInstanceName); 
		
		String helloWorld = "   \n \t Hello  ";
		System.out.println(helloWorld.trim()); 
		
		helloWorld = " ";
		System.out.println("Empty =" + helloWorld.isEmpty()); 
		System.out.println("Blank =" + helloWorld.isBlank()); 
		
		//Dynamic locator
		//Đại diện cho 1 chuỗi %s
		//%b %t %d
		String dynaminButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button" + dynaminButtonXpath.format(dynaminButtonXpath, "login")); 
		System.out.println("Click to Search button" + dynaminButtonXpath.format(dynaminButtonXpath, "search")); 
		System.out.println("Click to Register button" + dynaminButtonXpath.format(dynaminButtonXpath, "register")); 
		
		
	}

}
