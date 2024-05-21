package codenest.com.CodeNest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String department;

    private String designation;


    @ElementCollection
    private List<String> setedContests;

    // Getter and Setter for setedContests
    public List<String> getSetedContests() {
        return setedContests;
    }

    public void setSetedContests(List<String> setedContests) {
        this.setedContests = setedContests;
    }
}
