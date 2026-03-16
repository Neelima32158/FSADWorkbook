package com.klu.service;

import com.klu.model.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Optional<Course> getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);

    List<Course> searchByTitle(String title);
}