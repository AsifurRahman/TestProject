package com.mbstu.ehcare.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(insertable=false,updatable=false)
    private Integer id;
    private String username;
    private String password;

    private String email;

    private boolean enabled;

    private String role;

    public User() {
        this.enabled =true;
    }

    public User(String username, String password, String email, boolean enabled, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                '}';
    }
}