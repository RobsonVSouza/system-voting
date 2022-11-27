package com.sicredi.votingSystem.service.impl;

import com.sicredi.votingSystem.dto.VoterDto;
import com.sicredi.votingSystem.models.Voter;
import com.sicredi.votingSystem.exception.DefaultException;
import com.sicredi.votingSystem.mapper.VoterMapper;
import com.sicredi.votingSystem.repository.VoterRepository;
import com.sicredi.votingSystem.service.VoterService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VoterServiceImpl implements VoterService {

    private final VoterRepository voterRepository;

    private final VoterMapper voterMapper;

    @Override
    public VoterDto save (VoterDto voterDto){
        Optional<Voter> voterEntity = voterRepository.findByCpf(voterDto.getCpf());
        if (voterEntity.isPresent()){
            throw new DefaultException("Cpf já cadastrado");
        }
        return voterMapper.toDoVoter(voterRepository.save(voterMapper.toVoterEntity(voterDto)));

    }

    @Override
    public VoterDto update(Long id, VoterDto voterDto){
        Optional<Voter> voterEntity = voterRepository.findById(id);
        if (voterEntity.isEmpty()){
            throw new DefaultException("Cpf não existe");
        }
        return voterMapper.toDoVoter(voterRepository.save(voterMapper.toVoterEntity(voterDto)));
    }

    @Override
    public VoterDto findById(Long id){
        Optional<Voter> voterEntity = voterRepository.findById(id);
        if (voterEntity.isEmpty()){
            throw new DefaultException("Eleitor não existe");
        }
        return voterMapper.toDoVoter(voterEntity.get());
    }

    @Override
    public VoterDto findByCpf(String cpf){
        Optional<Voter> voterEntity = voterRepository.findByCpf(cpf);
        if (voterEntity.isEmpty()){
            throw new DefaultException("Cpf especifico não existe");
        }
        return voterMapper.toDoVoter(voterEntity.get());
    }

    @Override
    public List<VoterDto> getAll(){
        return voterMapper.toListDto(voterRepository.findAll());

    }

    @Override
    public void delete(Long id){
        Optional<Voter> voterEntity = voterRepository.findById(id);

        if (voterEntity.isEmpty()){
            throw new DefaultException("Eleitor não existe");
        }
        voterRepository.deleteById(id);
    }


}
