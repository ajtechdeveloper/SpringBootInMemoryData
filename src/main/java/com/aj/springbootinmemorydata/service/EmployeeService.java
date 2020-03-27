package com.aj.springbootinmemorydata.service;

import com.aj.springbootinmemorydata.domain.Employee;
import com.aj.springbootinmemorydata.domain.PieChart;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee delete(Integer id);
    List<PieChart> getGenderDiversity();
    List<PieChart> getDepartmentData();
}
