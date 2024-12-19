package com.app.licenta.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalTime;

@Embeddable
public class DayHour {
    @Enumerated(EnumType.STRING)
    private Day day;

    private LocalTime hour;

    public DayHour() {}

    public DayHour(Day day, LocalTime hour) {
        this.day = day;
        this.hour = hour;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
}
