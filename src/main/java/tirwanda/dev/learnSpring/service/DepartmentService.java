package tirwanda.dev.learnSpring.service;

import tirwanda.dev.learnSpring.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department createDepartment(Department department);

    public List<Department> departmentList();

    public Department departmentById(Long id);

    public void deleteDepartment(Long id);

    public void updateDepartment(Long id,Department department);
}
