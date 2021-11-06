package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WeekService {

    @Autowired
    private DayService dayService;

    private HashMap<Integer, Double> weekTotals = new HashMap<>();

    public WeekDto getWeek(LocalDate date){
        List<DayDto> days = new ArrayList<>();
        for(int i=0; i<5; i++){
            DayDto dayDto = dayService.getDay(date);
            days.add(dayDto);
            date=date.plusDays(1L);
        }
        WeekDto weekDto = new WeekDto(days);
        weekDto.setMonthTotalExcludingWeek(this.monthTotalExcludingWeek(date));
        weekDto.setMonthTotal(this.monthTotal(date));
        weekDto.setYearTotalExcludingWeek(this.yearTotalExcludingWeek(date));
        weekDto.setYearTotal(this.yearTotal(date));
        return weekDto;
    }

    public HashMap<Integer, Double> weekTotals(){
        weekTotals =new HashMap<>();
        LocalDate end = LocalDate.of(2021,12,31);
        LocalDate next = LocalDate.of(2021, 1, 1);
        while(!next.isEqual(end)){
            if(next.getDayOfWeek() != DayOfWeek.SUNDAY &&  next.getDayOfWeek() != DayOfWeek.SATURDAY ){
                DayDto day = dayService.getDay(next);
                int wkOfYear = next.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
                if(weekTotals.get(wkOfYear) == null){
                    weekTotals.put(wkOfYear, day.getDiff());
                } else {
                    weekTotals.put(wkOfYear, weekTotals.get(wkOfYear) + day.getDiff());
                }
            }

            next = next.plusDays(1);
        }
        return weekTotals;
    }

    public double yearTotal(LocalDate date) {
        double total = 0;
        LocalDate start = LocalDate.of(date.getYear(), 1, 1);
        LocalDate end = LocalDate.of(date.getYear(), 12, 31);
        while(!start.isEqual(end.plusDays(1))){
            if(start.getDayOfWeek() != DayOfWeek.SUNDAY &&  start.getDayOfWeek() != DayOfWeek.SATURDAY ){
                total += 7.5;
            }

            start = start.plusDays(1);
        }
        return total;
    }

    public double yearTotalExcludingWeek(LocalDate date) {
        double total = 0;
        LocalDate start = LocalDate.of(date.getYear(), 1, 1);
        LocalDate end = LocalDate.of(date.getYear(), 12, 31);
        while(!start.isEqual(end.plusDays(1))){
            if(start.getDayOfWeek() != DayOfWeek.SUNDAY &&  start.getDayOfWeek() != DayOfWeek.SATURDAY ){
                DayDto day = dayService.getDay(start);
                if(day.getWeekOfYear() != date.get(ChronoField.ALIGNED_WEEK_OF_YEAR)){
                    total += day.getDiff();
                }
            }

            start = start.plusDays(1);
        }
        return total;
    }

    public double monthTotal(LocalDate date){
        double total = 0;
        LocalDate start = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate end = LocalDate.of(date.getYear(),date.getMonth(),date.lengthOfMonth());
        while(!start.isEqual(end.plusDays(1))){
            if(start.getDayOfWeek() != DayOfWeek.SUNDAY &&  start.getDayOfWeek() != DayOfWeek.SATURDAY ){
                total += 7.5;
            }
            start = start.plusDays(1);
        }
        return total;
    }

    public double monthTotalExcludingWeek(LocalDate date){
        double total = 0;
        LocalDate start = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate end = LocalDate.of(date.getYear(),date.getMonth(),date.lengthOfMonth());
        while(!start.isEqual(end.plusDays(1))){
            if(start.getDayOfWeek() != DayOfWeek.SUNDAY &&  start.getDayOfWeek() != DayOfWeek.SATURDAY ){
                DayDto day = dayService.getDay(start);
                if(day.getWeekOfYear() != date.get(ChronoField.ALIGNED_WEEK_OF_YEAR)){
                    total += day.getDiff();
                }
            }

            start = start.plusDays(1);
        }
        return total;
    }


}
