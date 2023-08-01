package com.example.trytwo.Service;

import com.example.trytwo.Model.Note;
import com.example.trytwo.Model.User;
import com.example.trytwo.Repository.NoteRepo;
import com.example.trytwo.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private   final NoteRepo noteRepo;
    public void addUser(User user) {

        userRepo.save(user);
    }

    public List<User> getUser() {
        return userRepo.findAll();
    }

    public User assignNoteToUser(int userId, int noteId) {

        Set<Note> noteSet = null;
        User user = userRepo.findById(userId).get();
        Note note = noteRepo.findById(noteId).get();

        noteSet = user.getAssignedNote();

         noteSet.add(note);
         user.setAssignedNote(noteSet);

         return userRepo.save(user);
    }
}
