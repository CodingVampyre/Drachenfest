package com.github.codingvampyre.drachenfest.repositories;

import com.github.codingvampyre.drachenfest.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    public Participant findByemail(String email);
}
