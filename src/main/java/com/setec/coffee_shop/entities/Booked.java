package com.setec.coffee_shop.entities;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "tbl_booked")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;
    @DateTimeFormat(pattern = "h:mm a")
    private LocalTime time;
    private int person;
    
}
