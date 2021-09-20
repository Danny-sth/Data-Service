package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
}
