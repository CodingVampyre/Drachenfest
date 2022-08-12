package com.github.codingvampyre.drachenfest.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
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

    @OneToMany(mappedBy = "event")
    private List<TicketType> ticketTypes;
}
