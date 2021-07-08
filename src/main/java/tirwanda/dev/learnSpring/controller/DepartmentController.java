package tirwanda.dev.learnSpring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tirwanda.dev.learnSpring.entity.Department;
import tirwanda.dev.learnSpring.exception.ResourceNotFoundException;
import tirwanda.dev.learnSpring.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.createDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> departmentList() {
        LOGGER.info("Inside departmentList of DepartmentController");
        return departmentService.departmentList();
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return departmentService.departmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/departments/{id}")
    public void updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.findDepartmentByName(departmentName);
    }

}
