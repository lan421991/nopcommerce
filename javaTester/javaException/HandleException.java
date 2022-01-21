package javaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class HandleException {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		File file = new File("D:/Testing.txt");
		FileOutputStream fileOS = new FileOutputStream(file);
		Thread.sleep(5000);
	}

}
