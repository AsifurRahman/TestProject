package com.mbstu.ehcare.model;
import javax.persistence.*;

/*
 * Created by Asif
 *
 */
@Entity
@Table(name="DonorTable")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    @Column(name = "Last_donation")
    private String dtime;

    @Column(name = "Eligible")
    private boolean eligble;

    public Donor() {
    }

    public Donor(String name, String bgroup, String dept, String email, String phone, String district, String dtime, boolean eligble) {
        this.name = name;
        this.bgroup = bgroup;
        this.dept = dept;
        this.email = email;
        this.phone = phone;
        this.district = district;
        this.dtime = dtime;
        this.eligble = eligble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public boolean isEligble() {
        return eligble;
    }

    public void setEligble(boolean eligble) {
        this.eligble = eligble;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bgroup='" + bgroup + '\'' +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", district='" + district + '\'' +
                ", dtime='" + dtime + '\'' +
                ", eligble=" + eligble +
                '}';
    }
}