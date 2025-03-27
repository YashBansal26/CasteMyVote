package com.castemyvote.vote.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private  VoteService voteService;

    @PostMapping("/{voterId}/{candidateId}")
    public ResponseEntity<String> vote(@PathVariable Long voterId , @PathVariable Long candidateId){
        return ResponseEntity.ok(voteService.vote(voterId, candidateId));
    }
}
