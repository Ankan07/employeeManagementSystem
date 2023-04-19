package com.dailycodebuffer.Springboot.tutorial.entity;

import com.dailycodebuffer.Springboot.tutorial.validation.IpAddress;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "PLease add department name")
    @NotEmpty(message = "Dept Name cannot be empty")
    @Email(message = "should be email")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
    @IpAddress
    private String ipAddress;

}
