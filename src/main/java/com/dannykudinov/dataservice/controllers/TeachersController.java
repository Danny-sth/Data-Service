package com.dannykudinov.dataservice.controllers;


import com.dannykudinov.dataservice.entity.Subject;
import com.dannykudinov.dataservice.entity.Teacher;
import com.dannykudinov.dataservice.services.SubjectService;
import com.dannykudinov.dataservice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeachersController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService
                .getAll();

    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService
                .getById(id);
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        Subject subject = subjectService.getSubjectById(teacher.getSubject().getId());
//        System.out.println("SUBJECT" + " " + subject);
        teacher.setSubject(subject);
        subject.setTeacher(teacher);
        System.out.println("TEACHER" + " " + teacher);
        return teacherService
                .save(teacher);
    }

}
