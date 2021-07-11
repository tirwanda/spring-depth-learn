package tirwanda.dev.learnSpring.service;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tirwanda.dev.learnSpring.entity.Department;
import tirwanda.dev.learnSpring.repository.DepartmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("AA")
                .departmentAddress("Jakarta")
                .departmentCode("AA-01")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("AA"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data Base On Valid Department Name")
    public void findDepartmentByNameTest() {
        String departmentName = "AA";
        Department department = departmentService.findDepartmentByName(departmentName);

        assertEquals(departmentName, department.getDepartmentName());
    }

    @Test
    @DisplayName("Get List Data of Department")
    public void departmentListTest() {
        List<Department> departmentList = departmentService.departmentList();
        assertNotNull(departmentList);
    }

}