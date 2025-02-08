package com.wealthfitness.repository;

import com.wealthfitness.model.Family;

import jakarta.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//long is primay kay and family is class
@Entity
@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
}
