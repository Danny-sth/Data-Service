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
        try {
            Optional<Subject> optional = subjectsRepo.findById(id);
            if (optional.isPresent()) {
                subject = optional.get();
                log.debug("Fetching subject by id {}", subject);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
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

    public Subject update(final int id, Subject subject) {
        log.debug("Method update start");
        Subject subjectInDB = getSubjectById(id);
        log.debug("Fetching subject {} from DB", subjectInDB);
        subjectInDB.setName(subject.getName());
        subjectInDB.getTeacher().setName(subject.getTeacher().getName());
        subjectInDB.getTeacher().setSurname(subject.getTeacher().getSurname());
        subjectInDB.getTeacher().setSalary(subject.getTeacher().getSalary());
        subjectsRepo.save(subjectInDB);
        log.debug("Save updated subject {} in DB", subjectInDB);
        log.debug("Method update finished");
        return subjectInDB;
    }


    public String delete(final int id) {
        log.debug("Method delete start");
        String message = null;
        try {
            if (subjectsRepo.findById(id).isPresent()) {
                subjectsRepo.deleteById(id);
                message = "Subject is deleted";
            } else throw
                    new NullPointerException();
        } catch (NullPointerException e) {
            message = "No such subject in database";
            log.debug(message);
        }
        log.debug("Method delete finished");
        return message;
    }
}