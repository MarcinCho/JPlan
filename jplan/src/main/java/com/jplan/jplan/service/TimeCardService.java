package com.jplan.jplan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jplan.jplan.entity.TimeCard;
import com.jplan.jplan.repository.TimeCardRepository;

@Service
public class TimeCardService {

    @Autowired
    private TimeCardRepository cardRepo;

    public TimeCard savePunchCard(TimeCard punchCard) {
        return cardRepo.save(punchCard);
    }

    public Optional<List<TimeCard>> getByUsername(String username) {
        return cardRepo.findByUsername(username);
    }

    public Optional<List<TimeCard>> getActiveCardsByUsername(String username) {
        return cardRepo.findActiveByUSername(username);
    }

}
