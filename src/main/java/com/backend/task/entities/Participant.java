package com.backend.task.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate; // import the LocalDate class
import java.util.List;

@Entity(name = "participants")
@Data
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String degree;
    private String university;
    private LocalDate startDate;
    private LocalDate graduationDate;
    @Column(unique = true)
    private String mainEmail;
    private String googleEmail;
    private String zoomEmail;
    private String githubEmail;
    private String jetbrainsEmail;
    private String cvLink;
    //@ManyToMany(mappedBy = "participants")
    //private List<Activity> activities;

}
