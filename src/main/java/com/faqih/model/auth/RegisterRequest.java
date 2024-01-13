package com.faqih.model.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

   @NotBlank
   @Size(min = 5, max = 100)
   private String username;

   @NotBlank
   @Size(min = 5, max = 100)
   private String password;

   @NotBlank
   @Size(min = 5, max = 100)
   private String name;
}
