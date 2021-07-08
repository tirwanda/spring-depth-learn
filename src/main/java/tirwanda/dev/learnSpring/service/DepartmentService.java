package tirwanda.dev.learnSpring.service;

import tirwanda.dev.learnSpring.entity.Department;
import tirwanda.dev.learnSpring.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department createDepartment(Department department);

    public List<Department> departmentList();

    public Department departmentById(Long id) throws ResourceNotFoundException;

    public void deleteDepartment(Long id);

    public void updateDepartment(Long id,Department department);

    public Department findDepartmentByName(String name);
}
