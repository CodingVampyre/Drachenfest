package com.github.codingvampyre.drachenfest.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    private UUID uuid;

    @NotNull
    private Date beginAt;

    @NotNull
    private Date endAt;
}
