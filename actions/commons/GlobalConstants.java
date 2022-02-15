package commons;

import java.io.File;

public class GlobalConstants {
	public static final String ADMIN_PAGE_LINK = "https://admin-demo.nopcommerce.com/admin/";
	public static final String PORTAL_PAGE_LINK = "https://demo.nopcommerce.com/admin/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "dowloadFiles";
	
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	public static final String DB_DEV_URL = "10.58.241.191:3360";
	public static final String DB_DEV_USER = "10.58.241.191:3360";
	public static final String DB_DEV_ADMIN = "10.58.241.191:3360";
	
	public static final String DB_TEST_URL = "10.58.241.191:3360";
	public static final String DB_TEST_USER = "10.58.241.191:3360";
	public static final String DB_TEST_ADMIN = "10.58.241.191:3360";
	
	public static final long SHORT_TIME_OUT = 5;
	public static final long LONG_TIME_OUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	
}
