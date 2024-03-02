package com.Spring_boot_transient.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student implements Serializable {

     /*
       1) @Transient--  like if we write @Transient on any fields before creating table in database then
                        it completely remove that column from the database while creating table.

                        but

                        if the table is already created in database and the data is already inserted in it
                        and if we try to fetch the data and over studentPhoneNumber if @transient is written then
                        we got the whoole data but studentPhoneNUmber: null

       2) @JsonIgnore -- if we provide this json ignore before creating table in database then column is created but
                         as we send data that column should be null.

                         and as all data is already stored and we try to fetch the data and we provide @jsonignore then
                         we should not get any value i.e from output studentPhoneNUmber column is skip from output.


     */

    private static final Long serialVersionUID= 1234567890L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @NotNull(message = "StudentFirstName should not be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets are allowed")
    @Column(name = "student_first_name")
    private String studentFirstName;

    @NotNull(message = "name should not be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets are allowed")
    @Column(name = "student_last_name")
    private String studentLastName;



    @Column(name = "student_email")
    @NotNull(message = "Email should not be null")
    @Email(regexp = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b", message = "Email must ending with @gmail.com")
    private String studentEmail;

      @JsonIgnore
//    @Transient
//    @Column(name = "student_phone_no")
//    @Size(min = 10, max = 10, message = "Size of phone number number be of 10 digits")
//    @NotNull(message = "Phone_Number should not be null")
    private String studentPhoneNo;

    @NotNull(message = "Student Address should not be null")
    @Column(name = "student_address")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Alphabets are allowed")
    private String studentAddress;


}
