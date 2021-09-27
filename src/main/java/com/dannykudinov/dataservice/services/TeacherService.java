package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.TeacherRepo;
import com.dannykudinov.dataservice.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    Logger log = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    TeacherRepo teacherRepo;

    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepo.findAll();
    }

    public Teacher getTeacherById(final int id) {
        log.debug("Method getTeacherById is start");
        Teacher teacher = null;
        Optional<Teacher> teacherFromDB = teacherRepo.findById(id);
        if (teacherFromDB.isPresent()) {
            teacher = teacherFromDB.get();
            log.debug("Fetching teacher by id {}", teacherFromDB);
        } else {
            log.debug("No such teacher in database");
        }
        log.debug("Method getTeacherById is finished");
        return teacher;
    }

    public Teacher saveTeacher(Teacher teacher) {
        log.info("Save teacher {} to database", teacher);
        return teacherRepo
                .save(teacher);
    }

    public Teacher updateTeacher(final int id, Teacher teacher) {
        log.debug("Method updateTeacher is start");
        Teacher teacherFromDB = getTeacherById(id);
        if (teacherFromDB != null) {
            log.debug("Fetching teacher {} from DB", teacherFromDB);
            teacherFromDB.setName(teacher.getName());
            teacherFromDB.setSurname(teacher.getSurname());
            teacherFromDB.setSalary(teacher.getSalary());
            teacherFromDB.getSubject().setName(teacher.getSubject().getName());
            teacherRepo.save(teacherFromDB);
            log.debug("Save updated teacher {} in DB", teacherFromDB);
        }
        log.debug("Method updateTeacher is finished");
        return teacherFromDB;
    }

    public String deleteTeacher(final int id) {
        log.debug("Method deleteTeacher start");
        String message;
        if (teacherRepo.findById(id).isPresent()) {
            teacherRepo.deleteById(id);
            message = "Teacher is deleted";
        } else {
            message = "No such teacher in database";
            log.debug(message);
        }
        log.debug("Method deleteTeacher finished");
        return message;
    }
}