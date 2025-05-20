package com.rxhul.habitlearn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private int valueCompleted;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    @JsonBackReference
    private Habit habit;


}
