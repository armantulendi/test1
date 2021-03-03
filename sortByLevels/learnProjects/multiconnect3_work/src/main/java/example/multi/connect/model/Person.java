package example.multi.connect.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name="first_name",length = 50)
    private String firstName;

    @NotEmpty
    @NotNull
    @Column(name="last_name",length = 50)
    private String lastName;

    @NotEmpty
    @NotNull
    @Column(length = 50)
    private String email;

    @NotEmpty
    @NotNull
    @Column(name="gender",length = 50)
    private String gender;


}