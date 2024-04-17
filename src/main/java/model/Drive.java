//package model;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.NamedQueries;
//import jakarta.persistence.NamedQuery;
//
//
//@Entity
//@NamedQueries({
//        //
//})
//public class Drive {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drive_seq")
//    private Long id;
//
//    @ManyToOne
//    private Vehicle preferredVehicle;
//
//    private String whereFrom;
//    private String whereTo;
//    private LocalDateTime ETA;
//    private String driveNumber;
//
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
//    public Vehicle getPreferredVehicle() {
//        return preferredVehicle;
//    }
//
//    public void setPreferredVehicle(Vehicle preferredVehicle) {
//        this.preferredVehicle = preferredVehicle;
//    }
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
