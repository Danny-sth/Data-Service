package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.SubjectsRepo;
import com.dannykudinov.dataservice.DAO.TeacherRepo;
import com.dannykudinov.dataservice.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    Logger log = LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    SubjectsRepo subjectsRepo;

    @Autowired
    TeacherRepo teacherRepo;

    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectsRepo
                .findAll();
    }

    public Subject getSubjectById(final int id) {
        log.debug("Method getSubjectById start");
        Subject subject = null;
        Optional<Subject> optional = subjectsRepo.findById(id);
        if (optional.isPresent()) {
            subject = optional.get();
            log.debug("Fetching subject by id {}", subject);
        } else {
            log.debug("No such subject exists");
        }
        log.debug("Method getSubjectById finished");
        return subject;
    }


    public Subject addSubject(Subject subject) {
        log.info("Save subject {} to database", subject);
        return subjectsRepo
                .save(subject);
    }

    public Subject updateSubject(final int id, Subject subject) {
        log.debug("Method updateSubject start");
        Subject subjectFromDB = getSubjectById(id);
        if (subjectFromDB != null) {
            log.debug("Fetching subject {} from DB", subjectFromDB);
            subjectFromDB.setName(subject.getName());
            subjectFromDB.getTeacher().setName(subject.getTeacher().getName());
            subjectFromDB.getTeacher().setSurname(subject.getTeacher().getSurname());
            subjectFromDB.getTeacher().setSalary(subject.getTeacher().getSalary());
            subjectsRepo.save(subjectFromDB);
            log.debug("Save updated subject {} in DB", subjectFromDB);
        }
        log.debug("Method updateSubject finished");
        return subjectFromDB;
    }


    public String deleteSubject(final int id) {
        log.debug("Method deleteSubject start");
        String message;
        if (subjectsRepo.findById(id).isPresent()) {
            subjectsRepo.deleteById(id);
            message = "Subject is deleted";
        } else {
            message = "No such subject in database";
            log.debug(message);
        }
        log.debug("Method deleteSubject finished");
        return message;
    }
}