package com.example.UserInfo.controller;

import com.example.UserInfo.model.UserEntity;
import com.example.UserInfo.repository.UserRepo;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @PostMapping
  public ResponseEntity<?> createUser(@Valid @RequestBody UserEntity userEntity, BindingResult result)
  {
    if(result.hasErrors())
    {
      List<Map<String, String>> validationErrors = new ArrayList<>();
      for (FieldError error : result.getFieldErrors()) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("field", error.getField());
        errorDetails.put("message", error.getDefaultMessage());
        validationErrors.add(errorDetails);
      }
      return ResponseEntity.badRequest().body(validationErrors);
    }
    userRepo.save(userEntity);
    return ResponseEntity.ok("User created successfully!");
  }


}
