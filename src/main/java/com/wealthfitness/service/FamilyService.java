package com.wealthfitness.service;

import com.wealthfitness.model.Family;
import com.wealthfitness.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FamilyService {

    @Autowired
    private FamilyRepository FamilyRepository;      //to access FamilyRepository class

    //saves family in database
    public Family registerFamily(Family family) {
        return FamilyRepository.save(family);   
    }

}