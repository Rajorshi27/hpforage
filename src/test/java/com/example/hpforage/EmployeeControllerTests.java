package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setEmployee_id("1");
        employee.setFirst_name("John");
        employee.setLast_name("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setTitle("Software Engineer");

        when(employeeManager.getEmployees()).thenReturn(new Employees(Arrays.asList(employee)));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'employee_id': '1', 'first_name': 'John', 'last_name': 'Doe', 'email': 'john.doe@example.com', 'title': 'Software Engineer'}]"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployee_id("2");
        employee.setFirst_name("Jane");
        employee.setLast_name("Smith");
        employee.setEmail("jane.smith@example.com");
        employee.setTitle("Project Manager");

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"employee_id\": \"2\", \"first_name\": \"Jane\", \"last_name\": \"Smith\", \"email\": \"jane.smith@example.com\", \"title\": \"Project Manager\"}"))
                .andExpect(status().isOk());
    }
}
