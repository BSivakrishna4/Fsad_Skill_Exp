package model;

public class Students {
int rollno;
String name;
String dept;
public Students(int rollno,String name,String dept)
{
	this.rollno=rollno;
	this.name=name;
	this.dept=dept;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
}
