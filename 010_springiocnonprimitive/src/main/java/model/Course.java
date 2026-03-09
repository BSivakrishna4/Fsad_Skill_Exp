package model;

public class Course {
	String coursecode;
	String cname;
	Faculty faculty; //NonPrimitive data type 
	public Course(String coursecode, String cname, Faculty faculty ) {
		this.coursecode=coursecode;
		this.cname=cname;
		this.faculty=faculty;
	}
	public String getCoursecode() {
		return this.coursecode;
	}
	public String getName() {
		return this.cname;
	}
	public String getFaculty() {
		return this.faculty.getFid() + "-" +this.faculty.getFname();
	}
	
}
