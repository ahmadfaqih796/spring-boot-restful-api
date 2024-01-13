package com.faqih.exception;

public class ApiException extends RuntimeException {
   public ApiException(String message) {
      super(message);
   }

}
