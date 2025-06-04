package in.starmaven.wealthwise.repository;

import in.starmaven.wealthwise.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
   Optional<User> findByEmail(String email);//finding by email
   List<User> findByFamilyId(Long familyId);
   boolean existsByEmail(String email);
}
