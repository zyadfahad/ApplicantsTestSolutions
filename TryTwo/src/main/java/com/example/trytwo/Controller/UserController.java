package com.example.trytwo.Controller;

import com.example.trytwo.Model.Note;
import com.example.trytwo.Model.User;
import com.example.trytwo.Repository.NoteRepo;
import com.example.trytwo.Service.NoteService;
import com.example.trytwo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

     private final UserService userService;
     private final NoteService noteService;


     @GetMapping("/getallusers")
     public ResponseEntity getUser(){
         List<User> user = userService.getUser();

         return ResponseEntity.status(200).body(user);
     }





     @GetMapping({"/getUsers" , "/" , "/list"})
     public ModelAndView getUsers(){
          ModelAndView mav = new ModelAndView("list-users");
         List<User> user = userService.getUser();

         mav.addObject("Users" , user);
         List<Note> note = noteService.getall();
         mav.addObject("notes" , note);
         return mav;
     }
     @GetMapping("/addUserForm")
     public ModelAndView addUserForm(){
         ModelAndView mav = new ModelAndView("add-user-form");
         User newUser = new User();
         mav.addObject("user" , newUser);
         return mav ;

     }


    @PostMapping("/addUser")
     public ResponseEntity addUser(@RequestBody User user){
          userService.addUser(user);
          return  ResponseEntity.status(200).body("user added");
    }

    @PutMapping("user/{userId}/note/{noteId}")
    public User assignNoteToUser(@PathVariable int userId , @PathVariable int noteId){

         return userService.assignNoteToUser(userId , noteId);

    }
}
