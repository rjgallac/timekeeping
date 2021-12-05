package uk.co.sheffieldwebprogrammer.timekeeping.time;

import java.util.Map;

public class SummaryDto {
    private Map<Integer, Double> weekTotals;
    private Map<Integer, MonthTotal> monthTotals;
    private double yearTotal;

    public Map<Integer, Double> getWeekTotals() {
        return weekTotals;
    }

    public void setWeekTotals(Map<Integer, Double> weekTotals) {
        this.weekTotals = weekTotals;
    }

    public Map<Integer, MonthTotal> getMonthTotals() {
        return monthTotals;
    }

    public void setMonthTotals(Map<Integer, MonthTotal> monthTotals) {
        this.monthTotals = monthTotals;
    }

    public double getYearTotal() {
        return yearTotal;
    }

    public void setYearTotal(double yearTotal) {
        this.yearTotal = yearTotal;
    }
}
