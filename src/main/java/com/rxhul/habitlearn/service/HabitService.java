package com.rxhul.habitlearn.service;

import com.rxhul.habitlearn.model.Habit;
import com.rxhul.habitlearn.repository.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    HabitRepo habitRepo;

    public List<Habit> getHabits() {
        return habitRepo.findAll();
    }

    public Habit addHabit(Habit habit) {
        return habitRepo.save(habit);
    }

    public Habit getHabitsById(long id) {
        if(!habitRepo.existsById(id)) {
            return habitRepo.findById(id).get();
        }
        return null;
    }

    public boolean deleteHabit(long id) {
        if(habitRepo.existsById(id)) {
            habitRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
