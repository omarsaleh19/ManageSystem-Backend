package com.backend.task.repositories;

import com.backend.task.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByMainEmail(String mainEmail);
    List<Participant> findByUniversity(String university);





}
