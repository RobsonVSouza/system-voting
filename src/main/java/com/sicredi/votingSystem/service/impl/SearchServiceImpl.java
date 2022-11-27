package com.sicredi.votingSystem.service.impl;

import com.sicredi.votingSystem.dto.SearchDto;
import com.sicredi.votingSystem.exception.DefaultException;
import com.sicredi.votingSystem.mapper.SearchMapper;
import com.sicredi.votingSystem.models.Search;
import com.sicredi.votingSystem.repository.SearchRepository;
import com.sicredi.votingSystem.service.SearchService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SearchServiceImpl implements SearchService {

    private final SearchRepository searchRepository;

    private final SearchMapper searchMapper;

    @Override
    public SearchDto save(SearchDto searchDto){
        Optional<Search> searchEntity = searchRepository.findByElection(searchDto.getElection());
        if(searchEntity.isPresent()){
            throw new DefaultException("Pesquisa já foi cadastrada");
        }
        return searchMapper.toDoSearch(searchRepository.save(searchMapper.toSearchEntity(searchDto)));
    }


}
