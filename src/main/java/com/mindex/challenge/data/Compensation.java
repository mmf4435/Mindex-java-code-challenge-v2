package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;

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
