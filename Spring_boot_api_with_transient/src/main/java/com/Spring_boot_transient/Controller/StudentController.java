package com.Spring_boot_transient.Controller;

import com.Spring_boot_transient.Entity.Student;
import com.Spring_boot_transient.Service.StudentServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){

        String str=  studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getALlStudent(){
       List<Student> list=  studentService.getALlStudent();
       return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId){
        Student student=  studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }


    @GetMapping("/get1")
    public ResponseEntity<List<Student>> getStudentByFirstName(@RequestParam("studentFirstName")  String studentFirstName){
        List<Student> list= studentService.getStudentByFirstName(studentFirstName);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/get2/{studentEmail}")
    public ResponseEntity<Student> getStudentByStudentEmail(@PathVariable("studentEmail") String studentEmail){
       Student student=studentService.getStudentByStudentEmail(studentEmail);
       return ResponseEntity.status(HttpStatus.OK).body(student);
    }


    @PutMapping("/update/{studentId}")
    public ResponseEntity<String> updateStudentById(@PathVariable("studentId") Integer studentId, @RequestBody Student student)
    {
        String str= studentService.updateStudentById(studentId, student);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }


    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Integer studentId){
        String str=studentService.deleteStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }



}
