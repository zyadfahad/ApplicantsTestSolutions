package com.example.trytwo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
/*
@Transactional
@Table
@Data
@AllArgsConstructor

@NoArgsConstructor
*/
@Getter
@Setter
@Entity
public class Note {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer noteId;
    private String title;
    private String body ;
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedNote")
    private Set<User> userSet = new HashSet<>();



}
