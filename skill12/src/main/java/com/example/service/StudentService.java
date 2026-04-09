package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.StudentRepository;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student save(Student student) {
        return repo.save(student);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student update(Long id, Student student) {
        student.setId(id);
        return repo.save(student);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}