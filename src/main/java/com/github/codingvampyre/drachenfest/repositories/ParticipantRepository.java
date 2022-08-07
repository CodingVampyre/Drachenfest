package com.github.codingvampyre.drachenfest.repositories;

import com.github.codingvampyre.drachenfest.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
