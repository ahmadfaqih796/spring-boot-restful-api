package com.faqih.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import com.faqih.model.WebResponse;
import com.faqih.model.auth.RegisterRequest;
import com.faqih.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

   @Autowired
   private UserService userService;

   @PostMapping(path = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public WebResponse<String> register(@RequestBody RegisterRequest request) {
      // POST request
      userService.register(request);
      return WebResponse.<String>builder().data("Register Success").build();
   }

}
