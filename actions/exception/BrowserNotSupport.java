package exception;

public class BrowserNotSupport extends IllegalArgumentException {

	public BrowserNotSupport(String browserName) {
		super(String.format("Browser with Name = %s is not support", browserName));
	}
	
}
