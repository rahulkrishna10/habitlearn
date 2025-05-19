package com.rxhul.habitlearn.repository;

import com.rxhul.habitlearn.model.Habit;
import com.rxhul.habitlearn.model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitLogRepo extends JpaRepository<HabitLog, Long> {
    List<HabitLog>findByHabitId(Long habitId);
}
