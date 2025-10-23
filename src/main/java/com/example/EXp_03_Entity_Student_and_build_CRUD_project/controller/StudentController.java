package com.example.EXp_03_Entity_Student_and_build_CRUD_project.controller;

import com.example.EXp_03_Entity_Student_and_build_CRUD_project.model.Student;
import com.example.EXp_03_Entity_Student_and_build_CRUD_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setDepartment(studentDetails.getDepartment());

        // Save the fetched entity, not a new detached one
        return studentRepository.save(student);
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student with ID " + id + " deleted successfully!";
    }
}