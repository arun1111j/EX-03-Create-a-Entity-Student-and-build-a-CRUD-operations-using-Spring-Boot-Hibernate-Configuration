package com.example.EXp_03_Entity_Student_and_build_CRUD_project.model;
import jakarta.persistence.*;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; private String name;
    private String department;
    private int age; // Getters and Setters public Long getId() { return id; }
    @Version
    private Long version;
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}