package com.rxhul.habitlearn.service;

import com.rxhul.habitlearn.model.HabitLog;
import com.rxhul.habitlearn.repository.HabitLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitLogService {
    @Autowired
    HabitLogRepo habitLogRepo;

    public HabitLog addHabitLog(HabitLog habitLog) {
        return habitLogRepo.save(habitLog);
    }

    public List<HabitLog> getHabitLogs(long id) {
        return habitLogRepo.findByHabitId(id);
    }
}
