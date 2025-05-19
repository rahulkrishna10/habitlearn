package com.rxhul.habitlearn.controller;

import com.rxhul.habitlearn.model.Habit;
import com.rxhul.habitlearn.model.HabitLog;
import com.rxhul.habitlearn.service.HabitLogService;
import com.rxhul.habitlearn.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HabitLogController {
    @Autowired
    HabitLogService habitLogService;
    HabitService habitService;

    @GetMapping("/habits/{id}/logs")
    public ResponseEntity<?> getHabitLogs(@PathVariable long id) {
        List<HabitLog> habitLogs = habitLogService.getHabitLogs(id);
        if(habitLogs == null || habitLogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No logs found.");
        }
        return ResponseEntity.ok(habitLogs);
    }

    @PostMapping("/habits/{id}/logs")
    public ResponseEntity<?> addHabitLog(@PathVariable long habitId, @RequestBody HabitLog habitLog) {
        Habit habit = habitService.getHabitsById(habitId);
        if(habit == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habit not found.");
        }

        habitLog.setHabit(habit);

        HabitLog savedHabitLog = habitLogService.addHabitLog(habitLog);
        if (savedHabitLog == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create habit log.");
        }
        return ResponseEntity.ok(savedHabitLog);
    }

}
