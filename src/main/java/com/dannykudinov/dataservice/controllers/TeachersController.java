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
                .getAllTeachers();

    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable final int id) {
        return teacherService
                .getTeacherById(id);
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService
                .saveTeacher(teacher);
    }

    @PutMapping("/updateTeacher/{id}")
    public Teacher updateTeacher(@PathVariable final int id,
                                 @RequestBody Teacher teacher) {
        return teacherService
                .updateTeacher(id, teacher);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable final int id) {
        teacherService.deleteTeacher(id);
    }

}
