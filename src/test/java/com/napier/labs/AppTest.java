package com.napier.labs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    static Main app;

    @BeforeAll
    static void init() {
        app = new Main();
    }

    @Test
    void printSalariesTestNull() {
        app.printSalaries(null);
    }

    @Test
    void printSalariesTestEmpty() {
        ArrayList<Employee> employess = new ArrayList<Employee>();
        app.printSalaries(employess);
    }

    @Test
    void printSalariesTestContainsNull()
    {
        ArrayList<Employee> employess = new ArrayList<Employee>();
        employess.add(null);
        app.printSalaries(employess);
    }

    @Test
    void printSalaries()
    {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Kevin";
        emp.last_name = "Chalmers";
        emp.title = "Engineer";
        emp.salary = 55000;
        employees.add(emp);
        app.printSalaries(employees);
    }

    @Test
    void testDisplayEmployee_withValidEmployee() {

        Employee manager = new Employee();
        manager.first_name = "Bob";
        manager.last_name = "Manager";

        Employee emp = new Employee();
        emp.emp_no = 100;
        emp.first_name = "Alice";
        emp.last_name = "Johnson";
        emp.title = "Software Engineer";
        emp.salary = 90000;
        emp.dept_name = "IT";
        emp.manager = manager;

        // Capture system output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Act
        app.displayEmployee(emp);

        // Restore System.out
        System.setOut(System.out);

        // Convert output to string
        String out = output.toString();

        // Assert expected printed fields
        assertTrue(out.contains("100"));
        assertTrue(out.contains("Alice"));
        assertTrue(out.contains("Johnson"));
        assertTrue(out.contains("Software Engineer"));
        assertTrue(out.contains("Salary:90000"));
        assertTrue(out.contains("IT"));
        assertTrue(out.contains("Manager: ")); // manager printed as object reference
    }

    @Test
    void testDisplayEmployee_nullEmployee() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Act
        app.displayEmployee(null);

        // Restore System.out
        System.setOut(System.out);

        // Assert: nothing printed
        assertEquals("", out.toString());
    }
}
