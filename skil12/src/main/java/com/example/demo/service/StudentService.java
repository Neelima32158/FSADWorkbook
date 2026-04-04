package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}