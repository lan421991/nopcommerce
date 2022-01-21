package javaOOP.Inheritance;

public class Animal {
	public Animal() {
		System.out.println("Parent's constructor"); 
	}
	
	public Animal(String name) {
		System.out.println("Parent's constructor" + name); 
	}
	
	public Animal(String name,String age) {
		System.out.println("Parent's constructor" + name); 
		System.out.println("Parent's constructor" + age); 
	}
}
