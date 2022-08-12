package com.github.codingvampyre.drachenfest.repositories;

import com.github.codingvampyre.drachenfest.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Account, Long> {
    public Account findByemail(String email);
}
