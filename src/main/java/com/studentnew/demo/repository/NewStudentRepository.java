package com.studentnew.demo.repository;

import com.studentnew.demo.entity.NewStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewStudentRepository extends JpaRepository<NewStudent,Long> {
}
