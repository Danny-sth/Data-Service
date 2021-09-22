package com.dannykudinov.dataservice.controllers;

import com.dannykudinov.dataservice.entity.Grade;
import com.dannykudinov.dataservice.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("grades")
    public Grade addGrade(
            @RequestParam(name = "studentId") int studentId,
            @RequestParam(name = "subjectId") int subjectId,
            @RequestBody Grade grade) {
        gradeService.add(studentId,
                subjectId, grade);
        return grade;
    }

    @PutMapping("grades")
    public Grade updateGrade(
            @RequestParam(name = "studentId") int studentId,
            @RequestParam(name = "subjectId") int subjectId,
            @RequestParam(name = "gradeId") int gradeID,
            @RequestBody Grade grade) {
        gradeService.update(studentId,
                subjectId, gradeID, grade);
        return grade;
    }
}
