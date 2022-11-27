package com.sicredi.votingSystem.repository;

import com.sicredi.votingSystem.models.Voter;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository <Voter,Long> {

    Optional <Voter> findByCpf(String cpf);
}
