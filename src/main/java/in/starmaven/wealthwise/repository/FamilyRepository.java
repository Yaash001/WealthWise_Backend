package in.starmaven.wealthwise.repository;

import in.starmaven.wealthwise.entity.Family;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface FamilyRepository extends MongoRepository<Family, String> {
    Optional<Family> findByName(String familyName);
}
