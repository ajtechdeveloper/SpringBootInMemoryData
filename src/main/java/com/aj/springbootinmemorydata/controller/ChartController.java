package com.aj.springbootinmemorydata.controller;

import com.aj.springbootinmemorydata.domain.PieChart;
import com.aj.springbootinmemorydata.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/chart")
public class ChartController {

    private static final Logger logger = LoggerFactory.getLogger(ChartController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/pie/genderDiversity")
    public List<PieChart> getGenderDiversity() {
        logger.info("In ChartController.getGenderDiversity...");
        return employeeService.getGenderDiversity();
    }

    @GetMapping("/pie/department")
    public List<PieChart> getDepartmentData() {
        return employeeService.getDepartmentData();
    }
}
