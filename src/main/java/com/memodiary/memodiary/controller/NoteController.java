package com.memodiary.memodiary.controller;

import com.memodiary.memodiary.models.Note;
import com.memodiary.memodiary.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;
    @GetMapping("/notes")
    public ResponseEntity<?> getNotes(){
        return ResponseEntity.ok(this.noteService.getNotes());
    }

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<?> getNoteById(@PathVariable String noteId){
        return ResponseEntity.ok(this.noteService.getNoteById(noteId));
    }

    @PostMapping("/notes")
    public ResponseEntity<?> addNote(@RequestBody Note note){
        return ResponseEntity.ok(this.noteService.addNote(note));
    }

    @PutMapping("/notes/{noteId}")
    public ResponseEntity<?> updateNote(@PathVariable String noteId, @RequestBody Note note){
        return ResponseEntity.ok(this.noteService.updateNote(noteId,note));

    }

    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable String noteId){
        this.noteService.deleteNote(noteId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
