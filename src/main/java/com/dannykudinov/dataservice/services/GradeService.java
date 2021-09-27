package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.GradeRepo;
import com.dannykudinov.dataservice.DAO.StudentsRepo;
import com.dannykudinov.dataservice.DAO.SubjectsRepo;
import com.dannykudinov.dataservice.entity.Grade;
import com.dannykudinov.dataservice.entity.Student;
import com.dannykudinov.dataservice.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService {

    static final Logger log =
            LoggerFactory.getLogger(GradeService.class);

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    StudentsRepo studentsRepo;

    @Autowired
    SubjectsRepo subjectsRepo;


    public Grade addGrade(final int studentId, final int subjectId,
                          Grade grade) {
        log.debug("Method addGrade start");
        Optional<Student> studentFromDB =
                studentsRepo.findById(studentId);
        if (studentFromDB.isPresent()) {
            Student student = studentFromDB.get();
            log.debug("Fetching student from DB - {}", studentFromDB);
            grade.setStudent(student);
        } else {
            log.debug("No such student exists");
        }
        Optional<Subject> subjectFromDB =
                subjectsRepo.findById(subjectId);
        log.debug("Fetching subject from DB - {}", subjectFromDB);
        if (subjectFromDB.isPresent()) {
            Subject subject = subjectFromDB.get();
            grade.setSubject(subject);
        } else {
            log.debug("No such subject exists");
        }
        gradeRepo.save(grade);
        log.debug("Save grade to DB - {}", grade);
        log.debug("Method addGrade finished");
        return grade;
    }

    public Grade updateGrade(final int studentId, final int subjectId,
                             final int gradeID,
                             Grade grade) {
        log.debug("Method updateGrade start");
        Optional<Student> studentFromDB =
                studentsRepo.findById(studentId);
        log.debug("Fetching student from DB - {}", studentFromDB);
        if (studentFromDB.isPresent()) {
            Student student = studentFromDB.get();
            grade.setStudent(student);
        } else {
            log.debug("No such student in database");
        }
        Optional<Subject> subjectFromDB =
                subjectsRepo.findById(subjectId);
        log.debug("Fetching subject from DB - {}", subjectFromDB);
        if (subjectFromDB.isPresent()) {
            Subject subject = subjectFromDB.get();
            grade.setSubject(subject);
        } else {
            log.debug("No such subject in database");
        }
        Optional<Grade> gradeFromDB =
                gradeRepo.findById(gradeID);
        if (gradeFromDB.isPresent()) {
            log.debug("Fetching grade from database");
            grade.setId(gradeFromDB.get().getId());
            gradeRepo.save(grade);
            log.debug("Save updating object GRADE to DB - {}", grade);
        } else {
            log.debug("No such grade in database");
        }
        log.debug("Method updateGrade finished");
        return grade;
    }
}
