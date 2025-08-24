/*


package com.Valo.journalApp.controller;

import com.Valo.journalApp.entity.Journal;
import com.Valo.journalApp.service.JournalService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("/journal")
class JournalControllerV2 {
    @Autowired
    private JournalService journalService;

    @GetMapping
    public ResponseEntity<List<Journal>> getJournalEntries() {
        List<Journal> entries = journalService.getEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }


    @GetMapping("/{myId}")
    public ResponseEntity<Journal> getJournalById(@PathVariable ObjectId myId) {
        Optional<Journal> journal = journalService.findById(myId);
        if (journal.isEmpty()) {
            return new ResponseEntity<>(journal.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping
    public ResponseEntity<?> createJournalEntries(@RequestBody JsonNode body) {
        try {
            if (body.isArray()) {
                // Handle bulk insert
                List<Journal> journals = new ArrayList<>();
                for (JsonNode node : body) {
                    Journal journal = new ObjectMapper().convertValue(node, Journal.class);
                    if (journal.getDate() == null) {
                        journal.setDate(LocalDateTime.now());
                    }
                    journals.add(journal);
                }
                List<Journal> saved = journalService.saveAllEntries(journals);
                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            } else {
                // Handle single insert
                Journal journal = new ObjectMapper().convertValue(body, Journal.class);
                if (journal.getDate() == null) {
                    journal.setDate(LocalDateTime.now());
                }
                journalService.saveEntry(journal);
                return new ResponseEntity<>(journal, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId) {
        journalService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{myId}")
    public ResponseEntity<?> updateJournal(@PathVariable ObjectId myId, @RequestBody Journal updatedJournal) {
        try {
            Journal old = journalService.findById(myId).orElse(null);

            if(old!=null){
                old.setTitle(updatedJournal.getTitle() != null && !updatedJournal.getTitle().equals("")?updatedJournal.getTitle() : old.getTitle());
                old.setContent(updatedJournal.getContent() != null && !updatedJournal.getContent().equals("")?updatedJournal.getContent() : old.getContent());
            }
            journalService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(updatedJournal, HttpStatus.BAD_REQUEST);
        }
    }

}


*/
