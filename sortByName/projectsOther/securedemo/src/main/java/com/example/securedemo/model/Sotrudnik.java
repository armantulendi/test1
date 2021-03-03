package com.example.securedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sotrudnik {
    private Long id;
    private String firstName;
    private String lastName;

    public Sotrudnik(long l, String petr, String petrov) {
    }

    public Long getId() {
        return id;
    }
}
