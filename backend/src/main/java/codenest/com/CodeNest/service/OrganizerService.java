package codenest.com.CodeNest.service;

import codenest.com.CodeNest.entity.Organizer;

public interface OrganizerService {
    Organizer registerOrganizer(Organizer organizer);
    Organizer loginOrganizer(String email, String password);
}
