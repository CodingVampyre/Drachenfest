package com.github.codingvampyre.drachenfest.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Participant extends BaseEntity {

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

}
