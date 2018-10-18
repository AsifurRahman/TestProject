package com.mbstu.ehcare.model;
import javax.persistence.*;

/*
 * Created by Asif
 *
 */
@Entity
@Table(name="DoctorTable")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Doctor_ID")
    private String D_id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Degree")
    private String degree;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    public Doctor() {
    }


    public Doctor(String d_id, String name, String degree, String email, String phone) {
        D_id = d_id;
        this.name = name;
        this.degree = degree;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getD_id() {
        return D_id;
    }

    public void setD_id(String d_id) {
        D_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", D_id='" + D_id + '\'' +
                ", name='" + name + '\'' +
                ", degree='" + degree + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
