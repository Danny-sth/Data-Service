package com.dannykudinov.dataservice.controllers;


import com.dannykudinov.dataservice.entity.Teacher;
import com.dannykudinov.dataservice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeachersController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService
                .getAll();

    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService
                .getById(id);
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService
                .save(teacher);
    }

}
