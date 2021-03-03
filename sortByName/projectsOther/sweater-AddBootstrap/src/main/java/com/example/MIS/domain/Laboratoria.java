package com.example.MIS.domain;

import javax.persistence.*;

@Entity
public class Laboratoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nomer;
    private String result;
    private String iin;
    private String kod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Laboratoria() {
    }

    public Laboratoria(String nomer, String result,String iin, String kod, User author) {
        this.nomer = nomer;
        this.result = result;
        this.kod = kod;
        this.author = author;
        this.iin=iin;

    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getIin() {
        return iin;
    }
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
