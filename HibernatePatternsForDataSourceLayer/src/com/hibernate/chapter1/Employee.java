package com.hibernate.chapter1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "EmployeeInfo")
public class Employee {
    private int empId;
    private String empName;
    private String empPassword;
    private String empEmailAddress;
    private boolean isPermanent;
    private Calendar empJoinDate;
    private Date empLoginTime;

    /**
     * https://docs.oracle.com/javaee/5/api/javax/persistence/Transient.html
     * 
     */
    @Transient
    public String getEmpPassword() {
	return empPassword;
    }

    public void setEmpPassword(String empPassword) {
	this.empPassword = empPassword;
    }

    @Column(nullable = false)
    public String getEmpEmailAddress() {
	return empEmailAddress;
    }

    public void setEmpEmailAddress(String empEmailAddress) {
	this.empEmailAddress = empEmailAddress;
    }

    public boolean isPermanent() {
	return isPermanent;
    }

    /**
     * Unless you like to lazy fetch, then @Basic(fetch=FetchType.LAZY)
     * Otherwise this is implicit.
     * 
     * https://docs.oracle.com/javaee/6/api/javax/persistence/Basic.html
     * https://stackoverflow.com/questions/1383229/java-persistence-jpa-column-vs-basic
     */
    @Basic
    public void setPermanent(boolean isPermanent) {
	this.isPermanent = isPermanent;
    }

    /**
     * @Temporal maps the difference between:
     *   java.util.Date | java.util.Calendar __VS__ java.sql.Date | java.sql.Time | java.sql.Timestamp
     * 
     * https://docs.oracle.com/javaee/6/api/javax/persistence/Temporal.html
     * https://docs.oracle.com/javaee/6/api/javax/persistence/TemporalType.html
     * https://stackoverflow.com/questions/25333711/what-is-the-use-of-the-temporal-annotation-in-hibernate
     * 
     * The key aspect is that java.sql.[Date/Time/Timestamp] has more precise determination than a more general java.util.[Data/Calendar]
     * 
     */
    @Temporal(TemporalType.DATE)
    public Calendar getEmpJoinDate() {
	return empJoinDate;
    }

    public void setEmpJoinDate(Calendar empJoinDate) {
	this.empJoinDate = empJoinDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getEmpLoginTime() {
	return empLoginTime;
    }

    public void setEmpLoginTime(Date empLoginTime) {
	this.empLoginTime = empLoginTime;
    }

    /**
     * Using @TableGenerator to generate and store separately the generated primary key sequence. 
     * 
     * https://docs.oracle.com/javaee/5/api/javax/persistence/TableGenerator.html
     * https://docs.oracle.com/javaee/5/api/javax/persistence/GenerationType.html
     *  
     * https://www.thoughts-on-java.org/jpa-generate-primary-keys/
     * https://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype
     * 
     * Note: Hibernate 5.2 not all that applied for Hibernate 3 that used in this tute. 
     * But for reading and learning knowledge of what capable to the latest version in Hibernate ORM.
     * http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#identifiers-generators
     * 
     */
    @Id
    @TableGenerator(name = "empid", table = "emppktb", pkColumnName = "empkey", pkColumnValue = "empValue", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "empid")
    @Column(name = "EmployeeId")
    public int getEmpId() {
	return empId;
    }

    public void setEmpId(int empId) {
	this.empId = empId;
    }

    public String getEmpName() {
	return empName;
    }

    public void setEmpName(String empName) {
	this.empName = empName;
    }
}
