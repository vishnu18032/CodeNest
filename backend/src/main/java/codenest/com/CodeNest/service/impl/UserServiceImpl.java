package codenest.com.CodeNest.service.impl;

import codenest.com.CodeNest.entity.User;
import codenest.com.CodeNest.repository.UserRepository;
import codenest.com.CodeNest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Add validation logic if needed
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        // Implement login logic
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addSolvedProblem(Long id, String problemId) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            List<String> solvedProblems = user.getSolvedProblems();
            solvedProblems.add(problemId);
            user.setSolvedProblems(solvedProblems);
            userRepository.save(user);
        }
        return user;
    }
}
