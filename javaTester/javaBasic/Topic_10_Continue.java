package javaBasic;

public class Topic_10_Continue {
	public static void main(String[] args) {
		//Nested for : for lồng nhau
		for (int i = 1; i <= 5; i++) {
			System.out.println("i=" +i);
			for (int j = 1; j <= 5; j++) {
				if(j==4) {
					continue;
				}
				System.out.println("j=" +j);

			}
		}
	}
}
