package com.sicredi.votingSystem.controllers;

import com.sicredi.votingSystem.dto.SearchDto;
import com.sicredi.votingSystem.service.SearchService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pesquisa")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    public ResponseEntity<SearchDto> save(@RequestBody @Valid SearchDto searchDto){
        return ResponseEntity.status(HttpStatus.OK).body(searchService.save(searchDto));

    }
}
