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
    private String wifi;  //yes == true no == false
    private String rules;
    private String cable;
    private String bathroom;
    private String rented;

    public long getId() {
        return id;
    }


    public String getRented() {
        return rented;
    }

    public void setRented(String rented) {
        this.rented = rented;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }
}
