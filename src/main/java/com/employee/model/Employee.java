package com.employee.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;  // Validation annotations
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empid;

    // Ensures name is not null and not empty
    @NotBlank(message = "Employee name cannot be blank")
    @Column(nullable = false, length = 25)
    private String empName;

    // Optional field (no validation required)
    @Column(length = 70)
    private String address;

    // Ensures email is valid format and not blank
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    // Ensures salary is positive value
    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be greater than zero")
    @Column(precision = 12, scale = 2)
    private BigDecimal salary;
}
