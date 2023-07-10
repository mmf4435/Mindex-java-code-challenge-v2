package com.mindex.challenge.data;

public class ReportingStructure {

    //Fields
    private final Employee employee;

    private int numberOfReports;

    //Constructor
    public ReportingStructure(Employee employee){
        this.employee = employee;
        setNumberOfReports(calcNumberOfReports(employee));
    }

    //Methods
    public Employee getEmployee(){
        return employee;
    }

    public int getNumberOfReports(){
        return numberOfReports;
    }

    private void setNumberOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
    }

    private int calcNumberOfReports(Employee emp){
        if(emp.getDirectReports().size() == 0){
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
