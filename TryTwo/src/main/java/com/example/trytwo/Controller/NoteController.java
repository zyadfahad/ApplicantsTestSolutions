package com.example.trytwo.Controller;

import com.example.trytwo.Model.Note;
import com.example.trytwo.Repository.NoteRepo;
import com.example.trytwo.Service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/getall")
    public ResponseEntity getAllNotes(){
        List<Note> notes = noteService.getall();
        return ResponseEntity.status(200).body(notes);
    }

    @PostMapping("/add")
    public ResponseEntity addNote(@RequestBody Note note){
        noteService.addNote(note);
        return ResponseEntity.status(200).body("Note Added");
    }


}
