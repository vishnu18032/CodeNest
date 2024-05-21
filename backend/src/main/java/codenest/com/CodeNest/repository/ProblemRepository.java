package codenest.com.CodeNest.repository;

import codenest.com.CodeNest.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findByContestCode(String code);

}
