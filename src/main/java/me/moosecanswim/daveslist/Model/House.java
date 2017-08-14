package me.moosecanswim.daveslist.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class House {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String description;
    private Boolean wifi;  //yes == true no == false
    private String rules;
    private String cable;
    private Boolean bathroom;
    private Boolean rented;

    public long getId() {
        return id;
    }


    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public Boolean getBathroom() {
        return bathroom;
    }

    public void setBathroom(Boolean bathroom) {
        this.bathroom = bathroom;
    }


}
