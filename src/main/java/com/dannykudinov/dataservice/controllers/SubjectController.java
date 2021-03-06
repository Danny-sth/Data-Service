package com.dannykudinov.dataservice.controllers;

import com.dannykudinov.dataservice.entity.Subject;
import com.dannykudinov.dataservice.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// В классе описаны все необходимые api-endpoints, класс был написан до подключения spring-data-rest
@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectService
                .getAllSubjects();
    }

    @GetMapping("/subjects/{id}")
    public Subject getSubjectById(@PathVariable final int id) {
        return subjectService
                .getSubjectById(id);

    }

    @PostMapping("/addSubject")
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService
                .addSubject(subject);
    }

    @PutMapping("/updateSubject/{id}")
    public Subject updateTeacher(@PathVariable final int id,
                                 @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);
    }

    @DeleteMapping("/deleteSubject/{id}")
    public String deleteSubject(@PathVariable final int id) {
        String message = subjectService.deleteSubject(id);
        return message;
    }
}
