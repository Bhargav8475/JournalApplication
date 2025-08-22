/*

package com.Valo.journalApp.controller;

import com.Valo.journalApp.entity.Journal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/journalCache")
class JournalController {
    private ArrayList<Journal> journalEntries = new ArrayList<Journal>();

    @GetMapping
    public ArrayList<Journal> getJournalEntries(){
        return journalEntries;
    }

    @PostMapping
    public String createJournalEntry(@RequestBody Journal myJournal){
        journalEntries.add(myJournal);
        return "201 Created";
    }

    @GetMapping("/{myId}")
    public Journal getJournalById(@PathVariable int myId){
        for(Journal journal : journalEntries){
            if(journal.getId() == myId)
                    return journal;
        }
        return null;
    }

    @DeleteMapping("/{myId}")
    public String deleteJournalById(@PathVariable int myId){
        for(int i=0;i< journalEntries.size();i++){
            if(journalEntries.get(i).getId() == myId){
                journalEntries.remove(i);
                return "Successfully deleted";
            }
        }
        return "Journal not found";
    }

    @PutMapping("/{myId}")
    public String updateJournal(@PathVariable int myId, @RequestBody Journal updatedJournal) {
        for (int i = 0; i < journalEntries.size(); i++) {
            if (journalEntries.get(i).getId() == myId) {
                journalEntries.set(i, updatedJournal); // replace the old entry with new one
                return "Updated Successfully";
            }
        }
        return "Journal not found";
    }

}
*/
