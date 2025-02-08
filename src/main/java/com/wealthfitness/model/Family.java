package com.wealthfitness.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "families")
@Data
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //for automatic genration
    private Long familyId;

    @Column(unique = true,nullable = false)
    private String familyName;

    //one family has many user it connect with Forign key
    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)      
    private List<User> members;
}

