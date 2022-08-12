package com.github.codingvampyre.drachenfest.services.participant;

import com.github.codingvampyre.drachenfest.domain.Participant;
import com.github.codingvampyre.drachenfest.dtos.ParticipantCreateRequestDto;
import com.github.codingvampyre.drachenfest.repositories.ParticipantRepository;
import com.github.codingvampyre.drachenfest.services.password.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Part;
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

    public Participant create(ParticipantCreateRequestDto participantCreateRequestDto) {
        // check if such a participant already exists
        Participant p = this.participantRepository.findByemail(participantCreateRequestDto.getEmail());
        if (p != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        // hash password
        String password = participantCreateRequestDto.getPassword();
        String passwordHash = this.passwordService.hash(password);

        Participant newParticipant = Participant.builder()
                .uuid(UUID.randomUUID())
                .email(participantCreateRequestDto.getEmail())
                .password(passwordHash)
                .build();

        // apply
        return this.participantRepository.save(newParticipant);
    }

}
