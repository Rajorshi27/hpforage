import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeManager.getEmployees().getEmployeeList();
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeManager.getEmployees().getEmployeeList().add(employee);
    }
}
