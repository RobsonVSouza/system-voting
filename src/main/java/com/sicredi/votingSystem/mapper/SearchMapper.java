package com.sicredi.votingSystem.mapper;

import com.sicredi.votingSystem.dto.SearchDto;
import com.sicredi.votingSystem.models.Search;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SearchMapper {

    public abstract SearchDto toDoVoter(Search searchEntity);

    public abstract Search toSearchEntity(SearchDto searchDto);

    public abstract List<SearchDto> toListDto(List<Search> entityList);

}
