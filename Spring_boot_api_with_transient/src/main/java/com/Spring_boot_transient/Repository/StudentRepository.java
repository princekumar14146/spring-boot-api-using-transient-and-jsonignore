package com.Spring_boot_transient.Repository;

import com.Spring_boot_transient.Entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    public Student findByStudentEmail(String studentEmail);

    @Query(value = "select * from student where student_first_name=:n" , nativeQuery = true)
    public List<Student> findByStudentFirstName(@Param("n") String studentFirstName);

}
