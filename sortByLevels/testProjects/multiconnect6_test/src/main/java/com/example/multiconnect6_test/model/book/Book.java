package com.example.multiconnect6_test.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id

    private int id;
    private String name;

//
//    public Book(int i, String spring_book) {
//        this.id=i;
//        this.name=spring_book;
//    }
}
