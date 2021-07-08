package tirwanda.dev.learnSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tirwanda.dev.learnSpring.entity.Department;
import tirwanda.dev.learnSpring.exception.ResourceNotFoundException;
import tirwanda.dev.learnSpring.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> departmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department departmentById(Long id) throws ResourceNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()) {
            throw new ResourceNotFoundException("Department not found");
        } else {
            return department.get();
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDepartment(Long id, Department departmentBody) {
        Department department = departmentRepository.findById(id).get();

        if (Objects.nonNull(departmentBody.getDepartmentName()) &&
                !"".equalsIgnoreCase(departmentBody.getDepartmentName())) {
            department.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(departmentBody.getDepartmentCode()) &&
                !"".equalsIgnoreCase(departmentBody.getDepartmentCode())) {
            department.setDepartmentCode(department.getDepartmentCode());
            department.setDepartmentCode(departmentBody.getDepartmentCode());
        }

        if (Objects.nonNull(departmentBody.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(departmentBody.getDepartmentAddress())) {
            department.setDepartmentAddress(departmentBody.getDepartmentAddress());
        }

        departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
