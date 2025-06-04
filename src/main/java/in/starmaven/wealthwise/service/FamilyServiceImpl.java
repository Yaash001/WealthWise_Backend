package in.starmaven.wealthwise.service;

import in.starmaven.wealthwise.entity.Family;
import org.springframework.stereotype.Service;
import in.starmaven.wealthwise.repository.FamilyRepository;

import java.util.Optional;

@Service("familyService")
public class FamilyServiceImpl implements FamilyService {
    
    private final FamilyRepository familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository=familyRepository;
    }

    @Override
    public Family save(Family family) {
        // Check if family with the same name already exists
        Optional<Family> existingFamily = familyRepository.findByName(family.getName()); 
        
        if (existingFamily.isPresent()) {
            throw new RuntimeException("Family with this name is already exist...");
        }
        return familyRepository.save(family);
    }
}