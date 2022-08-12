package com.github.codingvampyre.drachenfest.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class TicketType extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private Float price;
}
