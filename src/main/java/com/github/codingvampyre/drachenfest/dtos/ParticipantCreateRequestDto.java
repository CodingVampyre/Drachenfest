package com.github.codingvampyre.drachenfest.dtos;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ParticipantCreateRequestDto {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @NotEmpty
    @Size(min = 8)
    private String password;
}
