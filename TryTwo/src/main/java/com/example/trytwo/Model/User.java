package com.example.trytwo.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "USER")
@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer userId;
    private String name;
    private String pass;
    @ManyToMany
    @JoinTable(name = "user_note",joinColumns = @JoinColumn(name ="user_id"),
                   inverseJoinColumns = @JoinColumn(name = "note_id")
    )
    private Set<Note> assignedNote = new HashSet<>();




}
