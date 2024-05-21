package codenest.com.CodeNest.controller;

import codenest.com.CodeNest.entity.ResponseMessage;
import codenest.com.CodeNest.entity.User;
import codenest.com.CodeNest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        if (savedUser != null) {
            // Create a new ResponseMessage object
            ResponseMessage responseMessage = new ResponseMessage("User registered successfully", savedUser.getId());
            return ResponseEntity.ok().body(responseMessage);
        } else {
            return ResponseEntity.badRequest().body("Error registering user");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.loginUser(email, password);
        if (user != null) {
            return ResponseEntity.ok("Login successful for user with ID: " + user.getId());
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @GetMapping("/solved/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/solved/{id}")
    public ResponseEntity<User> addSolvedProblem(@PathVariable Long id, @RequestBody String problemId) {
        User user = userService.addSolvedProblem(id, problemId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
