package onetomany.demo.model;

import onetomany.demo.model.CreditCard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String credit;
//    @OneToMany
//    private Set<CreditCard> creditCard;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

//    public Set<CreditCard> getCreditCard() {
//        return creditCard;
//    }
//
//    public void setCreditCard(Set<CreditCard> creditCard) {
//        this.creditCard = creditCard;
//    }
}
