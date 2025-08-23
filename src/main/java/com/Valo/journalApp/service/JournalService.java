package com.Valo.journalApp.service;

import com.Valo.journalApp.entity.Journal;
import com.Valo.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public void saveEntry(Journal journal){
        journalRepository.save(journal);
    }

    public List<Journal> getEntries(){
        return journalRepository.findAll();
    }
    
    public Optional<Journal> findById(ObjectId objectId){
        return journalRepository.findById(objectId);
    }

    public void deleteById(ObjectId objectId){
        journalRepository.deleteById(objectId);
    }

    public List<Journal> saveAllEntries(List<Journal> journals) {
        return journalRepository.saveAll(journals);
    }


}
