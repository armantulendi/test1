package com.example.multiconnect6_test.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int id;
    private String userName;




    public User(int i, String john) {
        this.id=i;
        this.userName=john;
    }
}
