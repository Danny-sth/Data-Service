package com.dannykudinov.dataservice.services;

import java.util.List;
import com.dannykudinov.dataservice.DAO.TeacherRepository;
import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    public List<Teacher> getAll() {
        List<Teacher> allTeachers = repository.findAll();
        return allTeachers;
    }

}
