package com.sicredi.votingSystem.repository;

import com.sicredi.votingSystem.models.Search;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository <Search, Long>{

    Optional<Search> findByElectionId(String election);
}
