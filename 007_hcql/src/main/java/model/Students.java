package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	@Id
	@Column(name = "sid")
	int sid;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "cgpa")
	double cgpa;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", name=" + name + ", cgpa=" + cgpa + "]";
	}
	

}
