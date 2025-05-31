package in.starmaven.wealthwise.repository;

import in.starmaven.wealthwise.entity.Family;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FamilyRepository extends MongoRepository<Family, String> {
}
