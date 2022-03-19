package com.daigo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Employee {
     private Integer id;
     private String lastname;
     private String email;
     private Integer gender;
     private Department department;
     private Date birth;

     public Employee(Integer id, String lastname, String email, Integer gender, Department department) {
          this.id = id;
          this.lastname = lastname;
          this.email = email;
          this.gender = gender;
          this.department = department;
          this.birth = new Date();
     }
}
