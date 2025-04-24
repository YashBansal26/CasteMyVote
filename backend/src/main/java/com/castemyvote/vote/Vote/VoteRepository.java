package com.castemyvote.vote.Vote;

import com.castemyvote.vote.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote , Long> {
    boolean existsByVoter(User voter);
}
