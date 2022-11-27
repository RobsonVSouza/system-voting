package com.sicredi.votingSystem.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchDto {

    private Long id;

    private String election;

    private Instant time = Instant.now().plusSeconds(60);

    private Integer positiveVote = 0;

    private Integer negativeVote =0;

    private String status = "Open".toLowerCase();

}
