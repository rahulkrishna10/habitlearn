package com.rxhul.habitlearn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String habitName;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    private int targetValue;
    private String unit;
    private String frequency;

    private boolean active = true;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    private List<HabitLog> logs;

}
