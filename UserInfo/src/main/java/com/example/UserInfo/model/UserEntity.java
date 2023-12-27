package com.example.UserInfo.model;

import com.example.UserInfo.annotations.ValidEmail;
import com.example.UserInfo.annotations.ValidEmailValidator;
import com.example.UserInfo.annotations.ValidName;
import com.example.UserInfo.annotations.ValidNameValidator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({UserEntity.class, ValidNameValidator.class, ValidEmailValidator.class})
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotBlank(message = "Name can't be empty!")
  @ValidName(message = "Name must contain only alphabets and spaces!", groups = ValidNameValidator.class)
  private String name;


  @Positive(message = "Age must be a positive number")
  @Min(value = 18, message = "Age must be at least 18")
  private int age;


  @Size(min = 10, max = 10, message = "Phone Number must contain exactly 10 digits!")
  private String phn_no;


  @ValidEmail(groups = ValidEmailValidator.class)
  private String email;


}
