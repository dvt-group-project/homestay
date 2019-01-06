package com.thinkpad.homestay.models;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    public UserRole userRole;

    @OneToMany
    private Collection<Reservation> reservations;

    @OneToMany
    private Collection<House> houses;

    public Collection<House> getHouses() {
        return houses;
    }

    public void setHouses(Collection<House> houses) {
        this.houses = houses;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
