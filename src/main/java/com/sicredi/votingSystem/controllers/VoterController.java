package com.sicredi.votingSystem.controllers;

import com.sicredi.votingSystem.service.VoterService;
import com.sicredi.votingSystem.dto.VoterDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class VoterController {

    @Autowired
    private VoterService voterService;


    @PostMapping
    public ResponseEntity<VoterDto> save(@RequestBody @Valid VoterDto voterDto){
        return ResponseEntity.status(HttpStatus.OK).body(voterService.save(voterDto));

    }

    @PutMapping("/{id}")
    public ResponseEntity <VoterDto> update(@PathVariable Long id,
            @RequestBody @Valid VoterDto voterDto){
        return ResponseEntity.status(HttpStatus.OK).body(voterService.update(id, voterDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoterDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(voterService.findById(id));
    }

    @GetMapping("/v1/{cpf}")
    public ResponseEntity<VoterDto> findByCpf(@PathVariable String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(voterService.findByCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<List<VoterDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(voterService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        voterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
