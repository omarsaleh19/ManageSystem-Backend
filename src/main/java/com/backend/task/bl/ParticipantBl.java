package com.backend.task.bl;

import com.backend.task.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.task.repositories.ParticipantRepository;

@Service
public class ParticipantBl {

    @Autowired
    private ParticipantRepository participantRepository;

    //creat new participant
    public Participant addParticipant(Participant participant) {
        if (participantRepository.findByMainEmail(participant.getMainEmail()) != null) {
            throw new IllegalArgumentException("Participant with this email "+participant.getMainEmail()+" already exists.");
        }
        if (participant.getGoogleEmail() == null || participant.getGoogleEmail().isEmpty()) {
            participant.setGoogleEmail(participant.getMainEmail());
        }

        if (participant.getZoomEmail() == null || participant.getZoomEmail().isEmpty()) {
            participant.setZoomEmail(participant.getMainEmail());
        }
        if (participant.getGithubEmail() == null || participant.getGithubEmail().isEmpty()) {
            participant.setGithubEmail(participant.getMainEmail());
        }

        if (participant.getJetbrainsEmail() == null || participant.getJetbrainsEmail().isEmpty()) {
            participant.setJetbrainsEmail(participant.getMainEmail());
        }
        return participantRepository.save(participant);
    }

    public void updateParticipantCvLink(String mainEmail, String newCvLink) {
        Participant participant = participantRepository.findByMainEmail(mainEmail);
        if (participant == null) {
            throw new IllegalArgumentException("Participant with email " + mainEmail + " does not exist.");
        }
        participant.setCvLink(newCvLink);
        participantRepository.save(participant);
    }
    public Participant getParticipantByEmail(String mainEmail) {
        Participant participant = participantRepository.findByMainEmail(mainEmail);
        if (participant == null) {
            throw new IllegalArgumentException("Participant with email " + mainEmail + " does not exist.");
        }
        return participant;
    }
    public void getParticipantByActivity(Integer activityId) {

    }


}
