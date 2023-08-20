package com.memodiary.memodiary.service;

import com.memodiary.memodiary.models.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    public void deleteNote(String noteId);
    public Note addNote(Note note);
    public Note updateNote(String noteId, Note note);
    public List<Note> getNotes();
    public Optional<Note> getNoteById(String noteId);

}
