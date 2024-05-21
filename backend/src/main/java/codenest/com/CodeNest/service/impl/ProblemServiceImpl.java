package codenest.com.CodeNest.service.impl;

import codenest.com.CodeNest.entity.Problem;
import codenest.com.CodeNest.repository.ProblemRepository;
import codenest.com.CodeNest.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemRepository problemRepository;



    @Override
    public Problem createProblem(Problem problem) {
        // Do any necessary validations or processing here
        return problemRepository.save(problem);
    }
    @Override
    public Problem getProblemById(Long id) {
        return problemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @Override
    public Problem updateProblem(Long id, Problem problem) {
        // Check if the problem with the given ID exists
        if (problemRepository.existsById(id)) {
            // Since the problem already exists, we don't need to set the ID explicitly
            // The ID should be set automatically by JPA when the problem is saved
            return problemRepository.save(problem);
        }
        return null; // Return null if the problem with the given ID doesn't exist
    }

    @Override
    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }

    @Override
    public List<Problem> getProblemsByContestCode(String code) {
        return problemRepository.findByContestCode(code);
    }
}
