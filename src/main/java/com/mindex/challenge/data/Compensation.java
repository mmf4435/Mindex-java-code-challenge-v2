package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Compensation.java
 * A type representing a compensation for an employee
 * @author Matt Favazza
 * @version 7/11/2023
 */
public class Compensation {

    //Fields
    private String employeeId;
    private BigDecimal salary;
    private Date effectiveDate;

    //Constructor
    public Compensation(String employeeId, BigDecimal salary, Date effectiveDate){
        this.employeeId = employeeId;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    //methods

    //accessor and mutators for fields
    public String getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public BigDecimal getSalary(){
        return salary;
    }
    public void setSalary(BigDecimal salary){
        this.salary = salary;
    }

    public Date getEffectiveDate(){
        return effectiveDate;
    }
    public void setEffectiveDate(Date effectiveDate){
        this.effectiveDate = effectiveDate;
    }
}
