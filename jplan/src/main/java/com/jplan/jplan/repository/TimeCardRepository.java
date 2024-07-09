package com.jplan.jplan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jplan.jplan.entity.TimeCard;

public interface TimeCardRepository extends JpaRepository<TimeCard, String> {

    public Optional<List<TimeCard>> findByUsername(String username);

    @Query(value = "SELECT * FROM time_card where username = ?1 and active = true", nativeQuery = true)
    public Optional<List<TimeCard>> findActiveByUSername(String username);

}
