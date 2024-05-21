package codenest.com.CodeNest.repository;

import codenest.com.CodeNest.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {
    List<Contest> findByStatus(String status);
    List<Contest> findByCode(String code);
    Contest findOneByCode(String code);
}
