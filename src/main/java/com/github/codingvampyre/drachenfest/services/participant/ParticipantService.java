package com.github.codingvampyre.drachenfest.services.participant;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import com.github.codingvampyre.drachenfest.services.password.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final PasswordService passwordService;

    public ParticipantService(ParticipantRepository participantRepository, PasswordService passwordService) {
        this.participantRepository = participantRepository;
        this.passwordService = passwordService;
    }

    public List<Participant> findAll() {
        return this.participantRepository.findAll();
    }

    public Participant findByemail(String email) {
        return this.participantRepository.findByemail(email);
    }

    public Participant create(Participant newParticipant) {
        // check if such a participant already exists
        Participant p = this.participantRepository.findByemail(newParticipant.getEmail());
        if (p != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        // generate uuid
        newParticipant.setUuid(UUID.randomUUID());

        // hash password
        String password = newParticipant.getPassword();
        String passwordHash = this.passwordService.hash(password);
        newParticipant.setPassword(passwordHash);

        // apply
        return this.participantRepository.save(newParticipant);
    }

}
