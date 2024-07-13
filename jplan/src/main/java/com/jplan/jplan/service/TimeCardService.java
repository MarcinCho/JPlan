package com.jplan.jplan.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jplan.jplan.entity.TimeCard;
import com.jplan.jplan.models.requests.TimeCardRequest;
import com.jplan.jplan.repository.TimeCardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TimeCardService {

    @Autowired
    private TimeCardRepository cardRepo;

    public TimeCard saveTimeCard(TimeCardRequest timeCardReq) {
        TimeCard timeCard = new TimeCard();
        timeCard.setProjectId(timeCardReq.getProjectId());
        timeCard.setUsername(timeCardReq.getUsername());
        timeCard.setActive(timeCardReq.isActive());
        timeCard.setEdited(timeCardReq.isEdited());
        timeCard.setComment(timeCardReq.getComment());

        if (timeCardReq.isActive()) {
            timeCard.setStopTime(null);
        } else {
            timeCard.setStopTime(new Date());
        }

        return cardRepo.save(timeCard);
    }

    public Optional<List<TimeCard>> getByUsername(String username) {
        return cardRepo.findByUsername(username);
    }

    public Optional<List<TimeCard>> getActiveCardsByUsername(String username) {
        return cardRepo.findActiveByUSername(username);
    }

}
