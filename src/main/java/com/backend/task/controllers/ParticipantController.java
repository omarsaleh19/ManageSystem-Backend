package com.backend.task.controllers;

import com.backend.task.bl.ParticipantBl;
import com.backend.task.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantBl participantBl;

    @PostMapping("/create")
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant) {
        System.out.println("Creating participant: " + participant.getMainEmail());
        try {
            Participant newParticipant = participantBl.addParticipant(participant);
            return ResponseEntity.status(HttpStatus.CREATED).body(newParticipant);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating participant: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }
    }

}
