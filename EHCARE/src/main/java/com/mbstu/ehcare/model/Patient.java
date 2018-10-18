package com.mbstu.ehcare.model;
import javax.persistence.*;

/*
 * Created by Asif
 *
 */
@Entity
@Table(name="PatientTable")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Id_Number")
    private String idno;

    @Column(name = "Name")
    private String name;

    @Column(name = "Blood_Group")
    private String bgroup;

    @Column(name = "Department")
    private String dept;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "district")
    private String district;

    public Patient() {
    }

    public Patient(String idno, String name, String bgroup, String dept, String email, String phone, String district) {
        this.idno = idno;
        this.name = name;
        this.bgroup = bgroup;
        this.dept = dept;
        this.email = email;
        this.phone = phone;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", idno='" + idno + '\'' +
                ", name='" + name + '\'' +
                ", bgroup='" + bgroup + '\'' +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}