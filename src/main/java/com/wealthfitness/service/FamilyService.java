package com.wealthfitness.service;

import com.wealthfitness.model.Family;
import com.wealthfitness.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FamilyService {

    @Autowired
    private FamilyRepository FamilyRepository;      //to access student repository class

    //pass family obj to FamilyRepository
    public Family registerFamily(Family family) {
        return FamilyRepository.save(family);   
    }

}