package javaOOP;

import java.util.Scanner;

public class Topic_01_Class_Object {
	public Topic_01_Class_Object(long maSV, String hoTen, float diemLT, float diemTH) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	protected long getMaSV() {
		return maSV;
	}
	protected void setMaSV(long maSV) {
		this.maSV = maSV;
	}
	protected String getHoTen() {
		return hoTen;
	}
	protected void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	protected float getDiemLT() {
		return diemLT;
	}
	protected void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	protected float getDiemTH() {
		return diemTH;
	}
	protected void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	
	protected float getDiemTB() {
		return (diemLT + diemTH*2)/3;
	}
	
	protected void showStudent() {
		System.out.println("MA SV : " + getMaSV()); 
		System.out.println("Ho Ten : " + getHoTen()); 
		System.out.println("diem LT : " + getDiemLT()); 
		System.out.println("diem TH : " + getDiemTH()); 
		System.out.println("diem TB : " + getDiemTB()); 
	}

	public static void main(String[] args) {
		Topic_01_Class_Object svA = new Topic_01_Class_Object(123,"Ngoc Hoa", 5.6f ,7.6f);
		svA.showStudent();
		
		Topic_01_Class_Object svB = new Topic_01_Class_Object(124,"Mai Tra", 6.6f ,8.6f);
		svB.showStudent();
	}
	private long maSV;
	private String hoTen;
	private float diemLT;
	private float diemTH;

}
