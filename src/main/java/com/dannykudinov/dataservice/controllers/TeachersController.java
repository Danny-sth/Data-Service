package com.dannykudinov.dataservice.controllers;


import java.util.List;
import com.dannykudinov.dataservice.entity.Teacher;
import com.dannykudinov.dataservice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeachersController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = teacherService.getAll();
        return teacherList;
    }
}
