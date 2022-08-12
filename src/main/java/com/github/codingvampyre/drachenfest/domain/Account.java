package com.github.codingvampyre.drachenfest.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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

    @OneToMany(mappedBy = "account")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "account")
    private List<Purchase> purchases;
}
