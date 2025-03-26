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
