package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList(){
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> dep = departmentRepository.findById(departmentId);
        if(!dep.isPresent()){
            throw  new DepartmentNotFoundException("Department Not Available Bro");
        }
        return  departmentRepository.findById(departmentId).get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
         return "department deleted successfully";
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dep = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase((department.getDepartmentName()))){
            dep.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase((department.getDepartmentCode()))){
            dep.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dep);
    }



    @Override
    public Department fetchDepartmentByDepartmentName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }


}
