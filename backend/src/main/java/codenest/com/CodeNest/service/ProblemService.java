package codenest.com.CodeNest.service;

import codenest.com.CodeNest.entity.Problem;

import java.util.List;

public interface ProblemService {
    Problem createProblem(Problem problem);
    Problem getProblemById(Long id);
    List<Problem> getAllProblems();
    Problem updateProblem(Long id, Problem problem);
    void deleteProblem(Long id);
    List<Problem> getProblemsByContestCode(String contestCode);

}
