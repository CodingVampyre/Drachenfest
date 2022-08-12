package com.github.codingvampyre.drachenfest.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Account extends BaseEntity {

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role = Role.Participant;

}
