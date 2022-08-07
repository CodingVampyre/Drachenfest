package com.github.codingvampyre.drachenfest.controllers;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class ParticipantController {

    private final ParticipantRepository participantRepository;

    ParticipantController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @GetMapping("/participants")
    List<Participant> list() {
        return this.participantRepository.findAll();
    }

    @GetMapping("/participants/{email}")
    Participant describeByUuid(@PathVariable String email) {
        System.out.println("Participant Mail: " + email.toString());
        return this.participantRepository.findByemail(email);
    }

    @PostMapping("/participants")
    Participant create(@RequestBody @Valid Participant participant) {
        participant.setUuid(UUID.randomUUID());
        return this.participantRepository.save(participant);
    }

}
