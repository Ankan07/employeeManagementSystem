package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Set;
@Service
public class ValidatorService {

    public void validateInput(Department department) throws ConstraintViolationException{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
