package com.rxhul.habitlearn.controller;


import com.rxhul.habitlearn.model.Habit;
import com.rxhul.habitlearn.model.HabitLog;
import com.rxhul.habitlearn.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class HabitController {

    @Autowired
    HabitService service;

    @GetMapping("/habits")
    public ResponseEntity<?> getHabits() {
        List<Habit> habits = service.getHabits();
        if(habits==null||habits.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No habits found.");
        }
        return ResponseEntity.ok(habits);
    }

    @PostMapping("/habits")
    public ResponseEntity<?> addHabit(@RequestBody Habit habit) {
        Habit savedHabit = service.addHabit(habit);
        if(savedHabit == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create habit.");
        }
        return ResponseEntity.ok(savedHabit);
    }

    @GetMapping("/habits/{id}")
    public ResponseEntity<?> getHabitsById(@PathVariable long id) {
        Habit habit = service.getHabitsById(id);
        if(habit == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No habit found.");
        }
        return ResponseEntity.ok(habit);
    }

    @DeleteMapping("/habits/{id}")
    public ResponseEntity<?> deleteHabit(@PathVariable long id) {
        boolean result = service.deleteHabit(id);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No habit found.");
        }
        return ResponseEntity.ok("Habit Deleted.");
    }



}
