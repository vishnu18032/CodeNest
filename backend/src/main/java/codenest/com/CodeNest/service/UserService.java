package codenest.com.CodeNest.service;

import codenest.com.CodeNest.entity.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    User getUserById(Long id);
    User addSolvedProblem(Long id, String problemId);
}
