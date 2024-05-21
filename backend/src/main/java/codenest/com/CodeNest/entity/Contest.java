package codenest.com.CodeNest.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String status;

    // Additional fields for problem creation
    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String inputFormat;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String outputFormat;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String constraints;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sampleInput;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sampleOutput;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String explanation;

    @ElementCollection
    private List<String> testCases;
}
