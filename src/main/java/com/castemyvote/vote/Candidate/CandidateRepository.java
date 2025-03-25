package com.castemyvote.vote.Candidate;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface CandidateRepository extends JpaRepository<Candidate , Long> {
}
