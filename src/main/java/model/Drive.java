//package model;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//import jakarta.persistence.*;
//
//
//@Entity
//@Table(name = "Drive")
////@NamedQueries({
////
////})
//public class Drive {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drive_seq")
//    private Long id;
//
//
//
//    private String whereFrom;
//    private String whereTo;
//    private LocalDateTime ETA;
//    private String driveNumber;
//
//
//
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "Drive_User",
//            joinColumns = { @JoinColumn(name = "drive_id") },
//            inverseJoinColumns = { @JoinColumn(name = "user_id") }
//    )
//    Set<User> users = new HashSet<>();
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    public Drive() {
//        super();
//    }
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
//
//    public String getWhereFrom() {
//        return whereFrom;
//    }
//
//    public void setWhereFrom(String whereFrom) {
//        this.whereFrom = whereFrom;
//    }
//
//    public String getWhereTo() {
//        return whereTo;
//    }
//
//    public void setWhereTo(String whereTo) {
//        this.whereTo = whereTo;
//    }
//
//    public LocalDateTime getETA() {
//        return ETA;
//    }
//
//    public void setETA(LocalDateTime ETA) {
//        this.ETA = ETA;
//    }
//
//    public String getDriveNumber() {
//        return driveNumber;
//    }
//
//    public void setDriveNumber(String driveNumber) {
//        this.driveNumber = driveNumber;
//    }
//
//}
