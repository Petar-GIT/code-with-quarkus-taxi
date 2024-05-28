//package model;
//
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//
//
//@Entity
//@NamedQueries({
//        @NamedQuery(name = Drive.GET_ALL_DRIVES, query = "Select d from Drive d")
//})
//public class Drive {
//
//    public static final String GET_ALL_DRIVES = "getAllDrives";
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drive_seq")
//    private Long id;
//
//
//
//
//    private String whereFrom;
//    private String whereTo;
//    private String driveNumber;
//    private double duration;
//
//
//    @ManyToOne
//    @JsonIgnore
//    public Vehicle vehicle;
//
//    public String number;
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
//    public String getDriveNumber() {
//        return driveNumber;
//    }
//
//    public void setDriveNumber(String driveNumber) {
//        this.driveNumber = driveNumber;
//    }
//
//    public double getDuration() {
//        return duration;
//    }
//
//    public void setDuration(double duration) {
//        this.duration = duration;
//    }
//}
