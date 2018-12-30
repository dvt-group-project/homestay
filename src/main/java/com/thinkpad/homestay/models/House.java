package com.thinkpad.homestay.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "houses")
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 55)
    @NotNull(message = "Not null em oi")
    private String name;

    @NotNull
    private String typeOfHouse;

    @NotNull
    private String address;

    @NotNull
    @Min(1)
    private int numberOfBathroom;

    @NotNull
    @Min(1)
    private int numberOfBedroom;

    @NotNull
    private String description;

    @NotNull
    private double pricePerNight;



    public House() {
    }

    public String getUrl() {
        String url="";
        Iterator iterator = imageHouses.iterator();
        while (iterator.hasNext()) {
            ImageHouse imageHouse = (ImageHouse) iterator.next();
            if (imageHouse.getAvatar() == 0) {
                url = imageHouse.getUrl();
            }
        }
        return url;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public boolean getStatus() {
        boolean statusIsLeasing = false;
        Iterator iterator = reservations.iterator();
        while (iterator.hasNext()) {
            Reservation reservation = (Reservation) iterator.next();
            if ("Leasing".compareTo(reservation.getStatus())==0) {
                statusIsLeasing = true;
                break;
            }
        }
        return statusIsLeasing;
    }

    @OneToMany(targetEntity = Reservation.class, mappedBy = "house")
    private Collection<Reservation> reservations;

    @OneToMany(targetEntity = ImageHouse.class, mappedBy = "house")
    public Collection<ImageHouse> imageHouses;

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

    public String getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(String typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfBathroom() {
        return numberOfBathroom;
    }

    public void setNumberOfBathroom(int numberOfBathroom) {
        this.numberOfBathroom = numberOfBathroom;
    }

    public int getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(int numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Collection<ImageHouse> getImageHouses() {
        return imageHouses;
    }

    public void setImageHouses(Collection<ImageHouse> imageHouses) {
        this.imageHouses = imageHouses;
    }
}

