package uk.co.sheffieldwebprogrammer.timekeeping.time;

import java.util.List;

public class WeekDto {

    List<DayDto> days;
    long weekTotal;

    public WeekDto(List<DayDto> days) {
        this.days = days;
    }

    public List<DayDto> getDays() {
        return days;
    }

    public void setDays(List<DayDto> days) {
        this.days = days;
    }

    public double getWeekTotal() {
        double total = 0;
        for (DayDto day : this.days) {
            total += day.getDiff();
        }
        return total;
    }

}
