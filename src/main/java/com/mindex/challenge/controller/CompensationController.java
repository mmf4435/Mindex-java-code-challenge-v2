package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CompensationController.java
 * A controller for creating and reading compensation objects
 * @author Matt Favazza
 * @version 7/11/2023
 */
@RestController
public class CompensationController {
    //Fields
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    //Methods
    //REST mapping for getting a compensation from a specified employee id
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id){
        LOG.debug("Received employee compensation create request for id [{}]", id);

        return compensationService.read(id);
    }

    //REST mapping for creating a new compensation from a specified employee id
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation){
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }
}
