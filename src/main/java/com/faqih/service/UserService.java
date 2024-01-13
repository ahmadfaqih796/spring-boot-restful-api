package com.faqih.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faqih.entity.User;
import com.faqih.exception.ApiException;
import com.faqih.model.auth.RegisterRequest;
import com.faqih.repository.UserRepository;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private Validator validator;

   public void register(RegisterRequest request) {
      Set<ConstraintViolation<RegisterRequest>> constraintViolations = validator.validate(request);
      if (constraintViolations.size() != 0) {
         // buat handle errornya
         throw new ConstraintViolationException(constraintViolations);
      }
      if (userRepository.existsByUsername(request.getUsername())) {
         throw new ApiException("Username ini sudah digunakan");
      }

      User user = new User();
      user.setUsername(request.getUsername());
      // user.setPassword(???);
   }
}