package com.example.BookstoreAPI.model;

import org.springframework.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private String password;

    // The constructor below is redundant due to @AllArgsConstructor, so it can be removed
    // public Customer(Long id, String name, String email, String password) {
    //    super();
    //    this.id = id;
    //    this.name = name;
    //    this.email = email;
    //    this.password = password;
    // }

    // Lombok automatically generates these methods, so they are not needed
    // public String getName() {
    //     return this.name;
    // }

    // public String getEmail() {
    //     return this.email;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }
}
