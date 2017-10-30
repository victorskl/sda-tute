package com.hibernate.onetomanymapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
    
    private int studentId;
    private String studentName;
    private College college;
    
    @Id
    @GeneratedValue
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    @ManyToOne
    //@JoinColumn(name="college_id")  // we can name the join column or let it auto 
    public College getCollege() {
        return college;
    }
    
    public void setCollege(College college) {
        this.college = college;
    }
}
