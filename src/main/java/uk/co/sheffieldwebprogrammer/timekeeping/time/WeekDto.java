package uk.co.sheffieldwebprogrammer.timekeeping.time;

import java.util.List;

public class WeekDto {

    List<DayDto> days;
    double weekTotal;
    double monthTotalExcludingWeek;
    double yearTotalExcludingWeek;
    double yearTotal;
    double monthTotal;

    public void setWeekTotal(double weekTotal) {
        this.weekTotal = weekTotal;
    }

    public double getMonthTotal() {
        return monthTotal;
    }

    public void setMonthTotal(double monthTotal) {
        this.monthTotal = monthTotal;
    }

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

    public double getMonthTotalExcludingWeek() {
        return monthTotalExcludingWeek;
    }

    public void setMonthTotalExcludingWeek(double monthTotalExcludingWeek) {
        this.monthTotalExcludingWeek = monthTotalExcludingWeek;
    }

    public void setYearTotalExcludingWeek(double yearTotalExcludingWeek) {
        this.yearTotalExcludingWeek = yearTotalExcludingWeek;
    }

    public double getYearTotalExcludingWeek() {
        return yearTotalExcludingWeek;
    }

    public double getYearTotal() {
        return yearTotal;
    }

    public void setYearTotal(double yearTotal) {
        this.yearTotal = yearTotal;
    }
}
