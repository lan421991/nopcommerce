package javaOOP;

public class Topic_05_This_Super {
	private int fisrtNumber;
	private int secondNumber;
	
	public Topic_05_This_Super(int fisrtNumber, int secondNumber) {
		this.fisrtNumber = fisrtNumber;
		this.secondNumber = secondNumber;
	}
	public void sumNumber() {
		System.out.println(fisrtNumber+secondNumber); 
	}
	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super(3, 5);
		topic.sumNumber();
	}
}
