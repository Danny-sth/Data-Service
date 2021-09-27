package com.dannykudinov.dataservice.controllers;

import com.dannykudinov.dataservice.entity.Grade;
import com.dannykudinov.dataservice.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// В классы описаны только POST и PUT методы, остальные сгенерированы spring-data-rest
@RestController
@RequestMapping("/")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping(path = "grades")
    public Grade addGrade(
            @RequestParam(name = "studentId") final int studentId,
            @RequestParam(name = "subjectId") final int subjectId,
            @RequestBody Grade grade) {
        gradeService.addGrade(studentId,
                subjectId, grade);
        return grade;
    }

    @PutMapping(path = "grades")
    public Grade updateGrade(
            @RequestParam(name = "studentId") final int studentId,
            @RequestParam(name = "subjectId") final int subjectId,
            @RequestParam(name = "gradeId") int gradeID,
            @RequestBody Grade grade) {
        gradeService.updateGrade(studentId,
                subjectId, gradeID, grade);
        return grade;
    }
}
