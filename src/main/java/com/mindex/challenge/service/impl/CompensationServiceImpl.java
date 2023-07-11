package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CompensationServiceImpl.java
 * implements the creation and reading of compensation objects to and from the compensation repository
 * @author Matt Favazza
 * @version 7/11/2023
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    //Fields
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    //Methods
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        Employee tmp = employeeRepository.findByEmployeeId(compensation.getEmployeeId());
        if(tmp == null){
            return null;
        }
        compensationRepository.insert(compensation);
        return compensation;
    }

    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation with employee id: [{}]", id);

        Compensation compensation = compensationRepository.findByEmployeeId(id);

        if(compensation == null){
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}
