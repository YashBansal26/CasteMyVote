package com.castemyvote.vote.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("/candidate")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.addCandidate(candidate));
    }

    @DeleteMapping("/candidate/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long id){
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok("Candidate deleted successfully.");
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getAllCandidates(){
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

}
