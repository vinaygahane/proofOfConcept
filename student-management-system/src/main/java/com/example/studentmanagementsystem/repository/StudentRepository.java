package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//NO need to add @Repository because IMPL(SimpleJpaRepository) of  JpaRepository contains @Repository
//JpaRepository also provides @Transactional
public interface StudentRepository extends JpaRepository<Student,Long> {//<Entity,type of primary key>

}
