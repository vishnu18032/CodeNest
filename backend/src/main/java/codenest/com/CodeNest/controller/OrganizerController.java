package codenest.com.CodeNest.controller;

import codenest.com.CodeNest.entity.Organizer;
import codenest.com.CodeNest.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerRepository organizerRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> registerOrganizer(@RequestBody Organizer organizer) {
        Organizer savedOrganizer = organizerRepository.save(organizer);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Organizer registered successfully");
        response.put("organizerId", savedOrganizer.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginOrganizer(@RequestParam String email, @RequestParam String password) {
        Organizer organizer = organizerRepository.findByEmail(email);
        if (organizer == null) {
            return ResponseEntity.badRequest().body("Invalid email");
        }
        if (!password.equals(organizer.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }
        return ResponseEntity.ok("Login successful for organizer with ID: " + organizer.getId());
    }

    @GetMapping("/seted/{id}")
    public ResponseEntity<Organizer> getOrganizer(@PathVariable Long id) {
        return ResponseEntity.ok(organizerRepository.findById(id).orElse(null));
    }

    @PatchMapping("/seted/{id}")
    public ResponseEntity<Organizer> addSetedContest(@PathVariable Long id, @RequestBody String code) {
        Organizer organizer = organizerRepository.findById(id).orElse(null);
        if (organizer == null) {
            return ResponseEntity.notFound().build();
        }
        List<String> setedContests = organizer.getSetedContests();
        setedContests.add(code);
        organizer.setSetedContests(setedContests);
        organizerRepository.save(organizer);
        return ResponseEntity.ok(organizer);
    }



}
