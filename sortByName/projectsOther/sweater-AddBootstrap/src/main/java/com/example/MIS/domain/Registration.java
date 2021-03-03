package com.example.MIS.domain;

import javax.persistence.*;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String patientName;
    private String mestoPrik;
    private String iin;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Registration() {
    }

    public Registration(String patientName, String mestoPrik,String iin,String address, User user) {
        this.author = user;
    this.address=address;
    this.patientName=patientName;
    this.mestoPrik=mestoPrik;
    this.iin=iin;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMestoPrik() {
        return mestoPrik;
    }

        public void setMestoPrik(String mestoPrik) {
        this.mestoPrik = mestoPrik;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String  iin) {
        this.iin = iin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
