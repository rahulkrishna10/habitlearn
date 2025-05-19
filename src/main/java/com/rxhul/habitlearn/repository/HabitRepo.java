package com.rxhul.habitlearn.repository;

import com.rxhul.habitlearn.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepo extends JpaRepository<Habit, Long> {}
