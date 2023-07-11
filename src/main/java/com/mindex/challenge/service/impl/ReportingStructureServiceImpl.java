package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure request(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        Employee fullEmployeeStruct = fillOutReporting(employee);
        ReportingStructure reportingStructure = new ReportingStructure(fullEmployeeStruct);
        reportingStructure.setEmployee(employee);

        return reportingStructure;
    }

    private Employee fillOutReporting(Employee emp){
        emp = employeeRepository.findByEmployeeId(emp.getEmployeeId());
        List<Employee> directs = emp.getDirectReports();
        if (directs != null && directs.size() != 0) {
            for (int i = 0; i < directs.size(); i++) {
                Employee direct = fillOutReporting(directs.get(i));
                directs.set(i, direct);
            }
            emp.setDirectReports(directs);
        }
        return emp;
    }
}
