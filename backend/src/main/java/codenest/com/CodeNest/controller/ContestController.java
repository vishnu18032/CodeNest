package codenest.com.CodeNest.controller;

import codenest.com.CodeNest.entity.Contest;
import codenest.com.CodeNest.entity.Problem;
import codenest.com.CodeNest.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codenest.com.CodeNest.service.ContestService;
import codenest.com.CodeNest.service.ProblemService;


import java.util.List;

@RestController
@RequestMapping("/contests")
public class ContestController {

    @Autowired
    private ContestService contestService;
    @Autowired
    private ContestRepository contestRepository;

    @GetMapping
    public ResponseEntity<?> getContests(@RequestParam(required = false) String status) {
        List<Contest> contests;
        if (status == null) {
            contests = contestRepository.findAll();
        } else {
            switch (status.toLowerCase()) {
                case "present":
                    contests = contestRepository.findByStatus("Present");
                    break;
                case "old":
                    contests = contestRepository.findByStatus("Old");
                    break;
                case "new":
                    contests = contestRepository.findByStatus("New");
                    break;
                default:
                    return ResponseEntity.badRequest().body("Invalid status: " + status);
            }
        }
        return new ResponseEntity<>(contests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contest> createContest(@RequestBody Contest contest) {
        try {
            Contest savedContest = contestRepository.save(contest);
            return new ResponseEntity<>(savedContest, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<Contest> getContest(@PathVariable String code) {
        Contest contest = contestService.getContestByCode(code);
        if (contest != null) {
            return ResponseEntity.ok(contest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Autowired
    private ProblemService problemService;

    @GetMapping("/{code}/problems")
    public ResponseEntity<List<Problem>> getProblemsByContestCode(@PathVariable String code) {
        List<Problem> problems = problemService.getProblemsByContestCode(code);
        if (problems != null) {
            return ResponseEntity.ok(problems);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

// Implement other CRUD operations (GET by ID, PUT, DELETE) as needed

