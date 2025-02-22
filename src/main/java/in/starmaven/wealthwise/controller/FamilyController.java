package in.starmaven.wealthwise.controller;

import in.starmaven.wealthwise.entity.Family;
import in.starmaven.wealthwise.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("familyController")
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Family family) {
        try {
            Family savedFamily = familyServiceImpl.save(family);
            return ResponseEntity.ok(savedFamily); // Return HTTP 200 OK with family info
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Family registration failed: " + e.getMessage());
        }
    }
}
