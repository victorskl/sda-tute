package com.hibernate.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonDetail {

    private int personDetialId;
    private String zipcode;
    private String job;
    private double income;
    private Person person;

    @OneToOne(mappedBy = "pDetail", cascade = CascadeType.ALL)
    public Person getPerson() {
	return person;
    }

    public void setPerson(Person person) {
	this.person = person;
    }

    @Id
    @GeneratedValue
    @Column(name = "detailId_PK")
    public int getPersonDetialId() {
	return personDetialId;
    }

    public void setPersonDetialId(int personDetialId) {
	this.personDetialId = personDetialId;
    }

    public String getZipcode() {
	return zipcode;
    }

    public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
    }

    public String getJob() {
	return job;
    }

    public void setJob(String job) {
	this.job = job;
    }

    public double getIncome() {
	return income;
    }

    public void setIncome(double income) {
	this.income = income;
    }
}
