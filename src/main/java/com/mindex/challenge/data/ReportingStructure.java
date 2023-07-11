package com.mindex.challenge.data;

/**
 * ReportingStructure.java
 * A type representing an employee and the total number of reports that they have.
 * @author Matt Favazza
 * @version 7/11/2023
 */
public class ReportingStructure {

    //Fields
    private Employee employee;

    private int numberOfReports;

    //Constructor
    public ReportingStructure(Employee employee){
        this.employee = employee;
        setNumberOfReports(calcNumberOfReports(employee));
    }

    //Methods

    // accessor and mutators
    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public int getNumberOfReports(){
        return numberOfReports;
    }

    private void setNumberOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
    }

    //Other methods
    /**
     * Calculates the number of reports that the employee has recursively
     * @param emp - the employee object to count reports from
     * @return the total number of reports including direct and indirect reports
     */
    private int calcNumberOfReports(Employee emp){
        if(emp.getDirectReports() == null || emp.getDirectReports().size() == 0){
            return 0;
        }
        else{
            int numberOfDirects = 0;
            for(Employee direct : emp.getDirectReports()){
                numberOfDirects ++;
                numberOfDirects += calcNumberOfReports(direct);
            }
            return numberOfDirects;
        }
    }
}
