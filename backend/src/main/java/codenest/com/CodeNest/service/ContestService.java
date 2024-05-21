package codenest.com.CodeNest.service;

import codenest.com.CodeNest.entity.Contest;

import java.util.List;

public interface ContestService {
    List<Contest> getAllContests();
    List<Contest> getPresentContests();
    List<Contest> getOldContests();
    List<Contest> getNewContests();
    Contest createContest(Contest contest);
    Contest updateContest(Long id, Contest contest);
    void deleteContest(Long id);
    Contest getContestByCode(String code);
}

