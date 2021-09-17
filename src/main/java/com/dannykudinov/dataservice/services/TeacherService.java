package com.dannykudinov.dataservice.services;

import com.dannykudinov.dataservice.DAO.TeacherRepository;
import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    public List<Teacher> getAll() {
        List<Teacher> allTeachers = repository.findAll();
        return allTeachers;
    }

    public Teacher getById(int id) {
        Teacher teacher = repository.findById(id)
                .get();
        return teacher;
    }

    public Teacher save(Teacher teacher) {
        repository.save(teacher);
        return teacher;
    }

}
