package com.thinkpad.homestay.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date checkInDate;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date checkOutDate;

    private String status;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne(targetEntity = House.class)
    @JoinColumn(name = "house_id")
    private House house;
}
