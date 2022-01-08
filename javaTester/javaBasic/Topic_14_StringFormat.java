package javaBasic;

public class Topic_14_StringFormat {
	public static String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation']//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation']//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation']//a[text()='Reward points']";
	public static String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation']//a[text()='Customer info']";
	
	public static String DYNAMIC_LINK_BY_PAGENAME = "xpath=//div[contains(@class,'account-navigation']//a[text()='%s']";
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGENAME = "xpath=//div[contains(@class,'%s']//a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(DYNAMIC_LINK_BY_PAGENAME,"Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGENAME,"My product reviews");
		clickToLink(DYNAMIC_LINK_BY_PAGENAME,"Reward points");
		clickToLink(DYNAMIC_LINK_BY_PAGENAME,"Customer info");
		
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGENAME,"account-navigation","Addresses");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGENAME,"account-navigation","My product reviews");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGENAME,"account-navigation","Reward points");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGENAME,"account-navigation","Customer info");
	}
	
	public static void clickToSideLink(String locator) {
		System.out.println("Click to " + locator); 
	}
//	
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		String locator = String.format(dynamicLocator, pageName);
//		System.out.println("Click to " + locator); 
//	}
//	
//	public static void clickToLink(String dynamicLocator,String areaName, String pageName) {
//		String locator = String.format(dynamicLocator, areaName, pageName);
//		System.out.println("Click to " + locator); 
//	}
	
	public static void clickToLink(String dynamicLocator,String...params) {
		String locator = String.format(dynamicLocator, (Object[])params);
		System.out.println("Click to " + locator); 
	}
	
	
}
