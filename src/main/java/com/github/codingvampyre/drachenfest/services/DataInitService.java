package com.github.codingvampyre.drachenfest.services;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import com.github.codingvampyre.drachenfest.services.participant.ParticipantService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class DataInitService {

    private final ParticipantService participantService;

    public DataInitService(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostConstruct
    public void init() {
        Participant p = new Participant();
        p.setEmail("participant@example.com");
        p.setPassword("Password123!");
        this.participantService.create(p);

        System.out.println("--- CREATED DEMO PARTICIPANT ---");
    }

}
