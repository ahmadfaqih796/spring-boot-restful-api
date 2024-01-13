package com.faqih.restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")

public class Contact {
   @Id
   private Integer id;
   private String username;
   @Column(name = "first_name")
   private Long firstName;
   @Column(name = "last_name")
   private Long lastName;
   private String phone;
   private String email;

   @ManyToOne
   @JoinColumn(name = "username", referencedColumnName = "username")
   private User user;
}