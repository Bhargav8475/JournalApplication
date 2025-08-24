package com.Valo.journalApp.service;

import com.Valo.journalApp.entity.Journal;
import com.Valo.journalApp.entity.User;
import com.Valo.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(Journal journal, String userName){
        try {
            User user = userService.findUserByUsername(userName);
            journal.setDate(LocalDateTime.now());
            Journal saved = journalRepository.save(journal);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveEntry(Journal journal){
        journalRepository.save(journal);
    }

    public List<Journal> getEntries(){
        return journalRepository.findAll();
    }
    
    public Optional<Journal> findById(ObjectId objectId){
        return journalRepository.findById(objectId);
    }

    @Transactional
    public void deleteById(String userName, ObjectId objectId){
        try {
            User user = userService.findUserByUsername(userName);
            user.getJournalEntries().removeIf(x -> x.getId().equals(objectId));
            userService.saveEntry(user);
            journalRepository.deleteById(objectId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Journal> saveAllEntries(List<Journal> journals) {
        return journalRepository.saveAll(journals);
    }




}
