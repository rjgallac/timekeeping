package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document
public class Day {

    @Id
    private String id;

    private LocalDate date;
    private LocalTime startAm;
    private LocalTime endAm;
    private LocalTime startPm;
    private LocalTime endPm;
    private String notes;

    public Day(LocalDate date, LocalTime startAm, LocalTime endAm, LocalTime startPm, LocalTime endPm, String notes) {
        this.date = date;
        this.startAm = startAm;
        this.endAm = endAm;
        this.startPm = startPm;
        this.endPm = endPm;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartAm() {
        return startAm;
    }

    public void setStartAm(LocalTime startAm) {
        this.startAm = startAm;
    }

    public LocalTime getEndAm() {
        return endAm;
    }

    public void setEndAm(LocalTime endAm) {
        this.endAm = endAm;
    }

    public LocalTime getStartPm() {
        return startPm;
    }

    public void setStartPm(LocalTime startPm) {
        this.startPm = startPm;
    }

    public LocalTime getEndPm() {
        return endPm;
    }

    public void setEndPm(LocalTime endPm) {
        this.endPm = endPm;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
