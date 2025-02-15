package com.wealthfitness.repository;

import com.wealthfitness.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;//to do CRUD operations on family table 
import org.springframework.stereotype.Repository;

//long is primay kay and family is class
@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
}
