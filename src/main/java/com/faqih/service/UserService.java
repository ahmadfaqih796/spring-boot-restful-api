package com.faqih.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.faqih.entity.User;
// import com.faqih.exception.ApiException;
import com.faqih.model.auth.RegisterRequest;
import com.faqih.repository.UserRepository;
import com.faqih.security.BCrypt;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private Validator validator;

   @Transactional
   public void register(RegisterRequest request) {
      Set<ConstraintViolation<RegisterRequest>> constraintViolations = validator.validate(request);
      if (constraintViolations.size() != 0) {
         // buat handle errornya
         throw new ConstraintViolationException(constraintViolations);
      }
      if (userRepository.existsByUsername(request.getUsername())) {
         // throw new ApiException("Username ini sudah digunakan");
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username ini sudah digunakan");
      }

      User user = new User();
      user.setUsername(request.getUsername());
      user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
      user.setName(request.getName());

      userRepository.save(user);
   }
}
