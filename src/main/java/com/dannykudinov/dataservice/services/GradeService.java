package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.GradeRepo;
import com.dannykudinov.dataservice.DAO.StudentsRepo;
import com.dannykudinov.dataservice.DAO.SubjectsRepo;
import com.dannykudinov.dataservice.DataServiceApplication;
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


    public Grade add(final int studentId, final int subjectId,
                     Grade grade) {
        Optional<Student> studentInDB =
                studentsRepo.findById(studentId);
        log.debug("Fetching student from DB " + studentInDB);
        if (studentInDB.isPresent()) {
            Student student = studentInDB.get();
            grade.setStudent(student);
        }
        Optional<Subject> subjectInDB =
                subjectsRepo.findById(subjectId);
        if (subjectInDB.isPresent()) {
            Subject subject = subjectInDB.get();
            grade.setSubject(subject);
        }
        gradeRepo.save(grade);
        return grade;
    }

    public Grade update(final int studentId, final int subjectId,
                        final int gradeID,
                        Grade grade) {
        Optional<Student> studentInDB =
                studentsRepo.findById(studentId);
        if (studentInDB.isPresent()) {
            Student student = studentInDB.get();
            grade.setStudent(student);
        }
        Optional<Subject> subjectInDB =
                subjectsRepo.findById(subjectId);
        if (subjectInDB.isPresent()) {
            Subject subject = subjectInDB.get();
            grade.setSubject(subject);
        }
        Optional<Grade> gradeInDB =
                gradeRepo.findById(gradeID);
        grade.setId(gradeInDB.get().getId());
        System.out.println(grade);
        gradeRepo.save(grade);
        return grade;
    }
}
