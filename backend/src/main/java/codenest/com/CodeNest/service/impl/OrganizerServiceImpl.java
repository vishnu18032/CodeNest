package codenest.com.CodeNest.service.impl;

import codenest.com.CodeNest.entity.Organizer;
import codenest.com.CodeNest.repository.OrganizerRepository;
import codenest.com.CodeNest.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerServiceImpl implements OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    public Organizer registerOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    @Override
    public Organizer loginOrganizer(String email, String password) {
        Organizer organizer = organizerRepository.findByEmail(email);
        if (organizer != null && organizer.getPassword().equals(password)) {
            return organizer;
        }
        return null;
    }
}
