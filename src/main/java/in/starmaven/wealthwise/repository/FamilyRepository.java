package in.starmaven.wealthwise.repository;

import in.starmaven.wealthwise.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;//to do CRUD operations on family table


public interface FamilyRepository extends JpaRepository<Family, Long> {
}
