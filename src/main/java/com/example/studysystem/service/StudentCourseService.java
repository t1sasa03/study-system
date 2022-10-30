package com.example.studysystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studysystem.data.Course;
import com.example.studysystem.data.Student;

@Service
public class StudentCourseService {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public StudentCourseService() {

        courses.add(new Course("Java", "IN PROGRESS"));
        courses.add(new Course("Cloud Services", "NOT STARTED"));
        courses.add(new Course("Front-end Web Development", "COMPLETED"));
        students.add(new Student("Hermione Granger"));
        students.add(new Student("Mickey Mouse"));
        students.add(new Student("Frodo Baggins"));

        addStudentsToTheCourse(1, 1);
        addStudentsToTheCourse(1, 2);
        addStudentsToTheCourse(0, 0);

    }

    public boolean addStudentsToTheCourse(long courseId, long studentId) {
        Course course = findCourse(courseId);
        Student student = findStudent(studentId);

        if (student != null && course != null) {
            course.addStudent(student);

            return true;
        }
        return false;
    }

    public Student findStudent(long studentId) {
        return students.stream()
                .filter(student -> student.getStudentId() == studentId)
                .findAny()
                .orElse(null);

    }

    public Course findCourse(long courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId() == courseId)
                .findAny()
                .orElse(null);

    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public String addStudent(String name) {
        Student s = new Student(name);
        students.add(s);
        return "";
    }

    public String addCourse(String courseName, String status) {
        Course c = new Course(courseName, status);
        courses.add(c);
        return "";
    }

}