package com.Spring_boot_transient.Service;

import com.Spring_boot_transient.Entity.Student;

import java.util.List;

public interface StudentService {

    public String saveStudent(Student student);
    public List<Student> getALlStudent();
    public Student getStudentById(Integer studentId);
    public List<Student> getStudentByFirstName(String studentFirstName);
    public Student getStudentByStudentEmail(String studentEmail);
    public String updateStudentById(Integer studentId, Student student);
    public String deleteStudentById(Integer studentId);


}
