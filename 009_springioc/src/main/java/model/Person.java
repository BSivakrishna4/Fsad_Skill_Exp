package model;

public class Person {
	String name;
	int age;
	String emailID;
	public Person(String name, int age, String emailID) {
		this.name=name;
		this.age=age;
		this.emailID=emailID;	
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String getemailID() {
		return this.emailID;
	}
	
}
