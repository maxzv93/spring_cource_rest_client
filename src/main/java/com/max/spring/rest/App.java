package com.max.spring.rest;

import com.max.spring.rest.configuration.MyConfig;
import com.max.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        //        List<Employee> allEmployees = communication.showAllEmployees();
        //        System.out.println(allEmployees.toString());

//        Employee employee = communication.getEmployee(1);
//        System.out.println(employee.toString());

//        Employee employee = new Employee("Petr", "Ivanov", "IT", 700);
//        employee.setId(10);
//        communication.saveEmployees(employee);

        communication.deleteEmployees(9);
    }
}








