package com.sicredi.votingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoterDto {

    private Long id;

    private String name;

    private String cpf;

}
