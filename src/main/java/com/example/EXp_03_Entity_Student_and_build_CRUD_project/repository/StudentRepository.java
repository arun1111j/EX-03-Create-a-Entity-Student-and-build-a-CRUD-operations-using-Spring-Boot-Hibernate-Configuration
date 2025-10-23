package com.example.EXp_03_Entity_Student_and_build_CRUD_project.repository;

import com.example.EXp_03_Entity_Student_and_build_CRUD_project.model.Student; import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> { }
