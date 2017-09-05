package com.hibernate.chapter3;

import javax.persistence.Embeddable;

@Embeddable
public class SchoolDetail {

    private String schooldAddress;
    private boolean isPublicSchool;
    private int studentCount;

    public String getSchooldAddress() {
	return schooldAddress;
    }

    public void setSchooldAddress(String schooldAddress) {
	this.schooldAddress = schooldAddress;
    }

    public boolean isPublicSchool() {
	return isPublicSchool;
    }

    public void setPublicSchool(boolean isPublicSchool) {
	this.isPublicSchool = isPublicSchool;
    }

    public int getStudentCount() {
	return studentCount;
    }

    public void setStudentCount(int studentCount) {
	this.studentCount = studentCount;
    }
}
