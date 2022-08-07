package com.github.codingvampyre.drachenfest.controllers;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("participants")
    Participant create(@RequestBody Participant participant) {
        return this.participantRepository.save(participant);
    }

}
