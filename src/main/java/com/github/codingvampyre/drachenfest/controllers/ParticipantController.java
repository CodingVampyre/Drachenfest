package com.github.codingvampyre.drachenfest.controllers;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import com.github.codingvampyre.drachenfest.services.participant.ParticipantService;
import com.github.codingvampyre.drachenfest.services.password.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class ParticipantController {

    private final ParticipantService participantService;

    ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/participants")
    List<Participant> list() {
        return this.participantService.findAll();
    }

    @GetMapping("/participants/{email}")
    Participant describeByUuid(@PathVariable String email) {
        return this.participantService.findByemail(email);
    }

    @PostMapping("/participants")
    Participant create(@RequestBody @Valid Participant participant) {
        return this.participantService.create(participant);
    }

}
