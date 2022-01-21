package javaOOP.Inheritance;

public class Dog extends Animal{
	public Dog() {
		super("Tom", "2");
		System.out.println("Child's Constructor"); 
	}
	public void Run() {
		System.out.println("Child's run"); 
	}
}
