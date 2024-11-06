package com.max.spring.rest;

import com.max.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ZuevMYu
 * @since 05.11.2024
 */
@Component
public class Communication {

    private final String URL = "http://localhost:8081/spring_cource_rest/api/employees";

    @Autowired
    private RestTemplate restTemplate;

    public List<Employee> showAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmployees(Employee employee) {
        Integer id = employee.getId();
        if (id == null) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("NEW emp was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Emp with id = " + employee.getId() + " was updated");
        }

    }

    public void deleteEmployees(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Emp with id = " + id + " was deleted");
    }
}























