package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name=Phone.GET_ALL_FOR_DRIVER, query = "Select p from Phone p where p.driver.id = :id")
})
public class Phone {


    public static final String GET_ALL_FOR_DRIVER = "getAllPhonesForDriver";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_seq")
    public Long id;

    @ManyToOne
    @JsonIgnore
    public Driver driver;

    public String number;

    public Phone() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
