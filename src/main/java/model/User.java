//package model;
//
//import jakarta.persistence.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Entity
//@Table(name = "User")
////@NamedQueries({
//////
////})
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    private Long id;
//
//    private String name;
//    private String card;
//    private String username;
//    private String surname;
//    private String jmbg;
//
//
//    @ManyToMany(mappedBy = "User")
//    private Set<Drive> drives = new HashSet<>();
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getCard() {
//        return card;
//    }
//
//    public void setCard(String card) {
//        this.card = card;
//    }
//
//    public String getJmbg() {
//        return jmbg;
//    }
//
//    public void setJmbg(String jmbg) {
//        this.jmbg = jmbg;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//}
