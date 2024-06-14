package com.jplan.jplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.PunchCard;

public interface PunchCardRepository extends JpaRepository<PunchCard, String> {

}
