package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DepartmentServiceTest {
    @Autowired
    private  DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeAll
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("America")
                .departmentCode("06")
                .departmentId(1L).build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    void saveDepartment() {
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    void fetchDepartmentById() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    @DisplayName("Fetch Dept By Name testing")
    public void fetchDepartmentByDepartmentName() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByDepartmentName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}