package com.example.trytwo.Service;

import com.example.trytwo.Model.Note;
import com.example.trytwo.Repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepo noteRepo;
    public List<Note> getall() {   return noteRepo.findAll();
    }

    public void addNote(Note note) {   noteRepo.save(note);     }
}
