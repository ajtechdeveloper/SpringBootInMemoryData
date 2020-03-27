package com.aj.springbootinmemorydata.service.impl;

import com.aj.springbootinmemorydata.domain.Employee;
import com.aj.springbootinmemorydata.domain.PieChart;
import com.aj.springbootinmemorydata.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private static List<Employee> employees = new ArrayList<>();
    private static Integer idCount = 0;

    static{
        employees.add(new Employee(++idCount, "Jim","Accounts", 10000,"Male"));
        employees.add(new Employee(++idCount, "John","HR", 15000,"Male"));
        employees.add(new Employee(++idCount, "Jane","IT", 20000,"Female"));
        employees.add(new Employee(++idCount, "Mary","HR", 15000,"Female"));
        employees.add(new Employee(++idCount, "Smith","IT", 25000,"Male"));
        employees.add(new Employee(++idCount, "Mark","Accounts", 12000,"Male"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee save(Employee employee) {
        if (employee.getId() == -1 || employee.getId() == 0) {
            employee.setId(++idCount);
            employees.add(employee);
        } else {
            delete(employee.getId());
            employees.add(employee);
        }
        Collections.sort(employees);
        logger.info("Sorted employees in EmployeeServiceImpl.save is: " + employee.toString());
        return employee;
    }

    public Employee delete(Integer id) {
        Employee employee = findById(id);
        if (employee == null)
            return null;
        if (employees.remove(employee)) {
            return employee;
        }
        return null;
    }

    public Employee findById(Integer id) {
        for (Employee course : employees) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List<PieChart> getGenderDiversity(){
        List<String> genders = new ArrayList<>();
        List<PieChart> genderDiversity = new ArrayList<>();
        for(Employee employee: employees){
            genders.add(employee.getGender());
        }
        Map<String, Long> genderMap =
                genders.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        if(!CollectionUtils.isEmpty(genderMap)){
            genderMap.forEach((k, v) -> genderDiversity.add(new PieChart(k,v.intValue())));
        }
        return genderDiversity;
    }

    public List<PieChart> getDepartmentData(){
        List<String> departments = new ArrayList<>();
        List<PieChart> departmentData = new ArrayList<>();
        for(Employee employee: employees){
            departments.add(employee.getDepartment());
        }
        Map<String, Long> departmentMap =
                departments.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        if(!CollectionUtils.isEmpty(departmentMap)){
            departmentMap.forEach((k, v) -> departmentData.add(new PieChart(k,v.intValue())));
        }
        return departmentData;
    }
}

