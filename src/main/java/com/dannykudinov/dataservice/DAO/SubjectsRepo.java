package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepo extends CrudRepository<Subject, Integer> {

    public List<Subject> findAll();

    public Subject findById(int id);

    public Subject save(Subject subject);

}
