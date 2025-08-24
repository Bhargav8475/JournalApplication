package com.Valo.journalApp.controller;

import com.Valo.journalApp.entity.Journal;
import com.Valo.journalApp.entity.User;
import com.Valo.journalApp.service.JournalService;
import com.Valo.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/journal")
class JournalControllerV3 {
    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getJournalEntriesOfUser(@PathVariable String userName) {
        User user = userService.findUserByUsername(userName);
        List<Journal> entries = user.getJournalEntries();
        if(entries != null && !entries.isEmpty()){
            return new ResponseEntity<>(entries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @PostMapping("/{userName}")
    public ResponseEntity<?> createJournalEntries(@RequestBody Journal journal, @PathVariable String userName) {
        try {
            journalService.saveEntry(journal, userName);
            return new ResponseEntity<>(journal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(journal, HttpStatus.BAD_REQUEST);
        }

    }



    @DeleteMapping("/{userName}/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId,@PathVariable String userName) {
        journalService.deleteById(userName, myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{userName}/{myId}")
    public ResponseEntity<?> updateJournal(@PathVariable String userName,
                                           @PathVariable ObjectId myId,
                                           @RequestBody Journal updatedJournal) {
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
