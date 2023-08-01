package com.example.trytwo.Repository;

import com.example.trytwo.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo  extends JpaRepository<Note,Integer> {
}
