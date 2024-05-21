package codenest.com.CodeNest.service.impl;

import codenest.com.CodeNest.entity.Contest;
import codenest.com.CodeNest.repository.ContestRepository;
import codenest.com.CodeNest.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestServiceImpl implements ContestService {

    private final ContestRepository contestRepository;

    @Autowired
    private ContestService contestService;


    @Autowired
    public ContestServiceImpl(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Override
    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    @Override
    public List<Contest> getPresentContests() {
        return contestRepository.findByStatus("Present");
    }

    @Override
    public List<Contest> getOldContests() {
        return contestRepository.findByStatus("Old");
    }

    @Override
    public List<Contest> getNewContests() {
        return contestRepository.findByStatus("New");
    }

    @Override
    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }

    @Override
    public Contest updateContest(Long id, Contest contest) {
        if (contestRepository.existsById(id)) {
            contest.setId(id); // Ensure the contest ID matches the provided ID
            return contestRepository.save(contest);
        }
        return null; // Return null if the contest with the given ID doesn't exist
    }

    @Override
    public void deleteContest(Long id) {
        contestRepository.deleteById(id);
    }

    @Override
    public Contest getContestByCode(String code) {
        return contestRepository.findOneByCode(code);
    }

}
