package com.castemyvote.vote.Vote;

import com.castemyvote.vote.Candidate.Candidate;
import com.castemyvote.vote.Candidate.CandidateRepository;
import com.castemyvote.vote.User.User;
import com.castemyvote.vote.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    public String vote(Long voterId, Long candidateId) {
        User voter = userRepository.findById(voterId).orElseThrow();
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow();
        
        if (voteRepository.existsByVoter(voter)) {
            return "You have already voted!";
        }

        Vote vote = new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);
        voteRepository.save(vote);

        candidate.setVotes(candidate.getVotes() + 1);
        candidateRepository.save(candidate);
        return "Vote successful!";
    }
}
