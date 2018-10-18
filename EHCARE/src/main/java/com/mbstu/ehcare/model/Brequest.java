package com.mbstu.ehcare.model;
import javax.persistence.*;

/*
 * Created by Asif
 *
 */
@Entity
@Table(name="BrequestTable")
public class Brequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Blood_Group")
    private String bgroup;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Location")
    private String location;

    public Brequest() {
    }

    public Brequest(String bgroup, String phone, String location) {
        this.bgroup = bgroup;
        this.phone = phone;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Brequest{" +
                "id=" + id +
                ", bgroup='" + bgroup + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}