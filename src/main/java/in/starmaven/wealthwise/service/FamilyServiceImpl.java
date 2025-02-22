package in.starmaven.wealthwise.service;

import in.starmaven.wealthwise.entity.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.starmaven.wealthwise.repository.FamilyRepository;


@Service("familyService")
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public Family save(Family family) {
        return familyRepository.save(family);
    }
}