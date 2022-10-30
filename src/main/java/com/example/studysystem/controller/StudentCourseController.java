package com.example.studysystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studysystem.data.Course;
import com.example.studysystem.data.Student;
import com.example.studysystem.service.StudentCourseService;

@Controller
public class StudentCourseController {
    @Autowired
    StudentCourseService studentCourseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", studentCourseService.getAllCourses());
        return "courses";
    }

    @GetMapping("courses/{id}")
    public String findCourse(Model model, @PathVariable long id) {

        Course c = studentCourseService.findCourse(id);
        List<Student> s = new ArrayList<>();
        s.addAll(studentCourseService.getAllStudents());
        s.removeAll(c.getStudents());

        model.addAttribute("course", c);
        model.addAttribute("students", s);

        return "course";
    }

    @PostMapping("/")
    public String addCourse(@RequestParam String courseName, @RequestParam String status) {
        studentCourseService.addCourse(courseName, status);
        return "redirect:/";
    }

    @GetMapping("students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentCourseService.getAllStudents());
        return "students";
    }

    @GetMapping("students/{id}")
    public String findStudent(Model model, @PathVariable long id) {
        model.addAttribute("student", studentCourseService.findStudent(id));
        return "student";
    }

    @PostMapping("students")
    public String createStudent(@RequestParam String name) {
        studentCourseService.addStudent(name);
        return "redirect:/students";
    }

    @PostMapping("/courses/{courseId}/students/{studentId}")
    public String addStudentToTheCourse(@PathVariable long courseId, @PathVariable long studentId) {
        studentCourseService.addStudentsToTheCourse(courseId, studentId);

        return "redirect:/courses/" + courseId;

    }

}
