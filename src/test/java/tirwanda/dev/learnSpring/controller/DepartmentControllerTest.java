package tirwanda.dev.learnSpring.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tirwanda.dev.learnSpring.entity.Department;
import tirwanda.dev.learnSpring.exception.ResourceNotFoundException;
import tirwanda.dev.learnSpring.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("AK")
                .departmentCode("AK-001")
                .departmentId(1L)
                .departmentAddress("Jakarta")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department department = Department.builder()
                .departmentName("AK")
                .departmentCode("AK-001")
                .departmentAddress("Jakarta")
                .build();

        Mockito.when(departmentService.createDepartment(department))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "    \"departmentName\": \"CC\",\n" +
                    "    \"departmentAddress\": \"Jakarta\",\n" +
                    "    \"departmentCode\": \"CC-01\"\n" +
                    "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findDepartmentById() throws Exception {
        Mockito.when(departmentService.departmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
    }
}