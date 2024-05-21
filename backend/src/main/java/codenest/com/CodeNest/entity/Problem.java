package codenest.com.CodeNest.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contestCode;
    private String difficulty;
    private String status;
    private String description;
    private String inputFormat;
    private String outputFormat;
    private String constraints;
    private String sampleInput;
    private String sampleOutput;
    private String explanation;

    @ElementCollection
    private List<String> testCases;

    // Getters and setters
}

