package com.github.codingvampyre.drachenfest.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "ticketType")
    private List<Ticket> tickets;
}
