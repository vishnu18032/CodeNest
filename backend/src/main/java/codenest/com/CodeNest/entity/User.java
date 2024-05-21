package codenest.com.CodeNest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_table") // Updated table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String mobile;
    private String password;
    private String department;
    private Integer YearofStudy;

    @ElementCollection
    private List<String> SolvedProblems;

    // Getter and setter methods for id, name, email, mobile, password, department, YearofStudy
    // (omitted for brevity)

    // Getter and setter for SolvedProblems
    public List<String> getSolvedProblems() {
        return SolvedProblems;
    }

    public void setSolvedProblems(List<String> solvedProblems) {
        this.SolvedProblems = solvedProblems;
    }
}