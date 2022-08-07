package com.github.codingvampyre.drachenfest.services;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class DataInitService {

    private final ParticipantRepository participantRepository;

    public DataInitService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @PostConstruct
    public void init() {
        Participant p = new Participant();
        p.setUuid(UUID.randomUUID());
        p.setEmail("participant@example.com");
        p.setPassword("Password123!");
        this.participantRepository.save(p);
        System.out.println("Created Participant " + p.getUuid());
    }

}
