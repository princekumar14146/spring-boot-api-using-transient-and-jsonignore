package com.Spring_boot_transient.Service.StudentServiceImpl;

import com.Spring_boot_transient.Entity.Student;
import com.Spring_boot_transient.Exception.DataAlreadyPresentException;
import com.Spring_boot_transient.Exception.NoDataAvailableException;
import com.Spring_boot_transient.Repository.StudentRepository;
import com.Spring_boot_transient.Service.StudentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @SneakyThrows
    @Override
    public String saveStudent(Student student) {
         Student student1= studentRepository.findByStudentEmail(student.getStudentEmail());
         if(student1!=null)
         {
             throw new DataAlreadyPresentException(student.getStudentEmail()+" is already registered");
         }
         else
         {
             studentRepository.save(student);
             return "Data stored Successfully in Database";
         }
    }

    @SneakyThrows
    @Override
    public List<Student> getALlStudent() {
        List<Student>  data= studentRepository.findAll();
        if(data.isEmpty())
        {
            throw new NoDataAvailableException("Database is empty");
        }
        else
        {
            return data;
        }
    }

    @SneakyThrows
    @Override
    public Student getStudentById(Integer studentId) {
        Optional<Student> student=studentRepository.findById(studentId);

        if(student.isEmpty())
        {
            throw new NoDataAvailableException("No data is available for studentId= "+studentId);
        }
        else
        {
            return student.get();
        }
    }

    @SneakyThrows
    @Override
    public List<Student> getStudentByFirstName(String studentFirstName) {
        List<Student> students=studentRepository.findByStudentFirstName(studentFirstName);

        if(students.isEmpty())
        {
            throw new NoDataAvailableException("No data is available related to studentFirstName= "+studentFirstName);
        }
        else {
            return students;
        }
    }

    @SneakyThrows
    @Override
    public Student getStudentByStudentEmail(String studentEmail) {

         Student student = studentRepository.findByStudentEmail(studentEmail);

         if(student!=null)
         {
            return student;
         }
         else {
             throw new NoDataAvailableException("THe email= "+studentEmail+" is not registered into database");
         }

    }

    @SneakyThrows
    @Override
    public String updateStudentById(Integer studentId, Student student) {

        Optional<Student> stu=studentRepository.findById(studentId);
        if(stu.isEmpty())
        {
            throw new NoDataAvailableException("There is no data related to studentId= "+studentId);
        }
        else {
            student.setStudentId(studentId);
            studentRepository.save(student);
            return "Data Updated Successfully";
        }


    }

    @SneakyThrows
    @Override
    public String deleteStudentById(Integer studentId) {
       Optional<Student> student=studentRepository.findById(studentId);

       if(student.isEmpty())
       {
           throw new NoDataAvailableException("No data is available regarding studentId= "+studentId);
       }
       else {
           studentRepository.deleteById(studentId);
           return "Data deleted Successfully";
       }
    }
}
