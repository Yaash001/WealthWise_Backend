package com.wealthfitness.controller;

import com.wealthfitness.model.Family;
import com.wealthfitness.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping("/Familysignup")//sending object to familyservice class to save
    public ResponseEntity<?> saveFamily(@RequestBody Family family) {
        try {
            Family savedFamily = familyService.registerFamily(family);
            return ResponseEntity.ok(savedFamily); // Return HTTP 200 OK with family info
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Family registration failed: " + e.getMessage());
        }
    }
}
