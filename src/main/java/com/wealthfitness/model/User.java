package com.wealthfitness.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //for automatic genration
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lasttName;

    //for full name
    public String fullName() {
        return (firstName+" "+(middleName != null ? middleName + " ": "")+lasttName);
    }

    @Column(unique = true,nullable = false) //allow unique values and notnull
    private String email;

    private String password;

    @Column(columnDefinition = "int(11)")
    private String contactNumber;

    @ManyToOne  //many user has one family it is Foreign key
    @JoinColumn(name = "family_id", nullable = false)   
    private Family family;
}
