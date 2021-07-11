package tirwanda.dev.learnSpring.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tirwanda.dev.learnSpring.entity.Department;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Jakarta")
                .departmentCode("IT-001")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("Test Methode FindByID")
    @Disabled
    public void findByIdTest() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("IT", department.getDepartmentName());
    }

    @Test
    @DisplayName("Test Methode Find By Department Name")
    public void findByDepartmentNameTest() {
        Department department = departmentRepository.findByDepartmentName("IT");
        assertEquals("IT", department.getDepartmentName());
    }

}