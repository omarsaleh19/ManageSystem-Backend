package com.backend.task;

import com.backend.task.bl.ParticipantBl;
import com.backend.task.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.backend.task.repositories.ParticipantRepository;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

	@Autowired
	private ParticipantRepository participantRepository;
	@Autowired
	private ParticipantBl participantBl;

	public static void main(String[] args) {

		SpringApplication.run(TaskApplication.class, args);
		Participant participant = new Participant();
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
