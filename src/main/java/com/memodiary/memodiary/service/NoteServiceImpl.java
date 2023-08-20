package com.memodiary.memodiary.service;

import com.memodiary.memodiary.exception.ResourceNotFoundException;
import com.memodiary.memodiary.models.Note;
import com.memodiary.memodiary.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void deleteNote(String noteId) {
        this.noteRepository.deleteById(noteId);
    }

    @Override
    public Note addNote(Note note) {
        noteRepository.save(note);
        return note;
    }

    @Override
    public Note updateNote(String noteId, Note note) {
        Note updateNote = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + noteId));

        updateNote.setTitle(note.getTitle());
        updateNote.setDescription(note.getDescription());

        noteRepository.save(updateNote);

        return updateNote;
    }

    @Override
    public List<Note> getNotes() {
        return this.noteRepository.findAll();
    }

    @Override
    public Optional<Note> getNoteById(String noteId) {
        return noteRepository.findById(noteId);
    }

}
