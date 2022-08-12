package com.github.codingvampyre.drachenfest.controllers;

import com.github.codingvampyre.drachenfest.domain.Account;
import com.github.codingvampyre.drachenfest.dtos.ParticipantCreateRequestDto;
import com.github.codingvampyre.drachenfest.services.participant.ParticipantService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController {

    private final ParticipantService participantService;

    AccountController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/participants")
    List<Account> list() {
        return this.participantService.findAll();
    }

    @GetMapping("/participants/{email}")
    Account describeByUuid(@PathVariable String email) {
        return this.participantService.findByemail(email);
    }

    @PostMapping("/participants")
    Account create(@RequestBody @Valid ParticipantCreateRequestDto participantCreateRequestDto) {
        return this.participantService.create(participantCreateRequestDto);
    }

}
