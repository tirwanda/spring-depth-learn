package tirwanda.dev.learnSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tirwanda.dev.learnSpring.entity.Department;
import tirwanda.dev.learnSpring.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> departmentList() {
        return departmentService.departmentList();
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Long id) {
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
