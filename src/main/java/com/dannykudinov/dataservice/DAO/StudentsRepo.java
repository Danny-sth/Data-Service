package com.dannykudinov.dataservice.DAO;

import com.dannykudinov.dataservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Student, Integer> {
}
