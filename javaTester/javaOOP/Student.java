package javaOOP;

public class Student {
	// thuộc tính
	private String carCompany;
	public Student(String carCompany, String carType, String flueType, Float mileAge, Double carPrice) {
		this.carCompany = carCompany;
		this.carType = carType;
		this.flueType = flueType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	private String carType;
	private String flueType;
	private Float mileAge;
	private Double carPrice;
	
	protected String getCarCompany() {
		return carCompany;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getCarType() {
		return carType;
	}

	protected void setCarType(String carType) {
		this.carType = carType;
	}

	protected String getFlueType() {
		return flueType;
	}

	protected void setFlueType(String flueType) {
		this.flueType = flueType;
	}

	protected Float getMileAge() {
		return mileAge;
	}

	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	protected Double getCarPrice() {
		return carPrice;
	}

	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}
	
	protected void showCarIndor() {
		System.out.println("Car Company " + getCarCompany()); 
		System.out.println("Car Type " + getCarType()); 
		System.out.println("Car Flue Type " + getFlueType()); 
		System.out.println("Car mile Age " + getMileAge()); 
		System.out.println("Car Price " + getCarPrice()); 
	}

	public static void main(String[] args) {
		Student honda = new Student("Honda","City","Petrol",150f, 50000d);
		honda.showCarIndor();
		
		Student toyota = new Student("Toyota","City","Petrol",150f, 50000d);
		toyota.showCarIndor();
		
	}

}
