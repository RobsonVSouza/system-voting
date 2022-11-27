package com.sicredi.votingSystem.service;

import com.sicredi.votingSystem.dto.VoterDto;
import java.util.List;

public interface VoterService {

    VoterDto save(VoterDto voterDto);

    VoterDto update(Long id, VoterDto voterDto);

    VoterDto findById(Long id);

    VoterDto findByCpf(String cpf);

    List<VoterDto> getAll();

    void delete(Long id);
}
