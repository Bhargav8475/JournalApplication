package com.Valo.journalApp.controller;

import com.Valo.journalApp.entity.Journal;
import com.Valo.journalApp.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
class JournalControllerV2 {
    @Autowired
    private JournalService journalService;

    @GetMapping
    public List<Journal> getJournalEntries() {
        return journalService.getEntries();
    }


    @GetMapping("/{myId}")
    public Journal getJournalById(@PathVariable ObjectId myId) {
        return journalService.findById(myId).orElse(null);
    }


    @PostMapping
    public Journal createJournalEntry(@RequestBody Journal myJournal) {
        myJournal.setDate(LocalDateTime.now());
        journalService.saveEntry(myJournal);
        return myJournal;
    }


    @DeleteMapping("/{myId}")
    public String deleteJournalById(@PathVariable ObjectId myId) {
        journalService.deleteById(myId);
        return "204 NO CONTENT";
    }


    @PutMapping("/{myId}")
    public String updateJournal(@PathVariable ObjectId myId, @RequestBody Journal updatedJournal) {
        Journal old = journalService.findById(myId).orElse(null);

        if(old!=null){
            old.setTitle(updatedJournal.getTitle() != null && !updatedJournal.getTitle().equals("")?updatedJournal.getTitle() : old.getTitle());
            old.setContent(updatedJournal.getContent() != null && !updatedJournal.getContent().equals("")?updatedJournal.getContent() : old.getContent());
        }
        journalService.saveEntry(old);
        return "200 OK";
    }

}
