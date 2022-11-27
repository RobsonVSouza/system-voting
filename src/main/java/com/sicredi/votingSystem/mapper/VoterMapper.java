package com.sicredi.votingSystem.mapper;

import com.sicredi.votingSystem.dto.VoterDto;
import com.sicredi.votingSystem.models.Voter;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class VoterMapper {

    public abstract VoterDto toDoVoter(Voter voterEntity);

    public abstract Voter toVoterEntity(VoterDto voterDto);

    public abstract List<VoterDto> toListDto(List<Voter> entityList);

}
