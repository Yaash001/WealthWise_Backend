package com.wealthfitness.controller;

import com.wealthfitness.model.Family;
import com.wealthfitness.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping("/Familysignup")//sending object to familyservice class to save
    public Family saveFamily(@RequestBody Family family) {
        return familyService.registerFamily(family);
    }
}
