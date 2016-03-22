package com.pavikumbhar.javaheart.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Student implements Serializable {
        
        @Id
	@GeneratedValue
	private int studentId;
	private String name;
	private String department;
	private String emailId;

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
