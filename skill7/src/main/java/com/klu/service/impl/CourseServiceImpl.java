package com.klu.service.impl;

import com.klu.model.Course;
import com.klu.repo.CourseRepo;
import com.klu.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo repo;

    @Override
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {

        Course existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Not Found"));

        existing.setTitle(course.getTitle());
        existing.setDuration(course.getDuration());
        existing.setFee(course.getFee());

        return repo.save(existing);
    }

    @Override
    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}