package com.example.MIS.domain;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String iin;
    private String analys;
    private String diagnos;
    private String kod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Doctor() {
    }

    public Doctor(String iin, String analys, String diagnos, String kod, User author) {
        this.iin = iin;
        this.analys = analys;
        this.diagnos = diagnos;
        this.kod = kod;
        this.author = author;

    }

    public String getAnalys() {
        return analys;
    }

    public void setAnalys(String analys) {
        this.analys = analys;
    }

    public String getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(String diagnos) {
        this.diagnos = diagnos;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
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

     public String getIin() {
        return iin;
    }

    public void setIin(String  iin) {
        this.iin = iin;
    }

     public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;

    }
}
