package com.faqih.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// T itu tanda sebagai generic class
public class WebResponse<T> {
   private T data;
   private String message;
   private String errors;
}
