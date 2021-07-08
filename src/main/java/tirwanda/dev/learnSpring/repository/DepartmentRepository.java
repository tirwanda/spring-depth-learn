package tirwanda.dev.learnSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tirwanda.dev.learnSpring.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
