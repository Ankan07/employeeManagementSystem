package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;
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
                 .departmentId(1L)
                 .departmentAddress("Ahmedabad")
                 .departmentName("CE")
                 .departmentCode("C")
                 .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department imputdepartment = Department.builder()
                .departmentAddress("K")
                .departmentName("test@gmail.com")
                .departmentCode("SWE")
                .build();
        Mockito.when(departmentService.saveDepartment(imputdepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON).content("{ \n" +
                        "    \"departmentName\":\"test@gmail.com\",\n" +
                        "    \"departmentAddress\":\"Kolkata\",\n" +
                        "    \"departmentCode\":\"SWE\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    void fetchDepartmentsById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void fetchDepartmentByName() {
    }
}