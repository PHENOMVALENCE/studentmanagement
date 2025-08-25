/**
  * @ Author: Valence Mwigani
  * @ Role: Full Stack Dev
  * @ Create Time: 2025-08-18 19:04:44
  * @ Modified by: Valence Mwigani
  * @ Modified time: 2025-08-18 21:25:33
  * @ Description:
  */

package com.valence.studentmanagement.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String email;
}
