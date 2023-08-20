package com.memodiary.memodiary.repository;

import com.memodiary.memodiary.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {

}
