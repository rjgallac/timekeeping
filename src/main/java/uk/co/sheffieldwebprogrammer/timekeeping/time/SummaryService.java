package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

@Service
public class SummaryService {
    @Autowired
    private DayService dayService;

    @Cacheable(value="summary")
    public SummaryDto weekTotals(){
        Map<Integer, Double> weekTotals = new HashMap<>();
        Map<Integer, MonthTotal> monthTotals = new HashMap<>();
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
                int mthOfYear = next.getMonthValue();
                if(monthTotals.get(mthOfYear) == null){
                    MonthTotal value = new MonthTotal(next.getMonth().name(),7.5, day.getDiff());
                    monthTotals.put(mthOfYear, value);
                } else {
                    MonthTotal value = new MonthTotal(next.getMonth().name(), monthTotals.get(mthOfYear).getExpected() + +7.5, monthTotals.get(mthOfYear).getActual() + day.getDiff());
                    monthTotals.put(mthOfYear, value);
                }
            }
            next = next.plusDays(1);
        }
        SummaryDto summaryDto = new SummaryDto();
        summaryDto.setWeekTotals(weekTotals);
        summaryDto.setMonthTotals(monthTotals);
        return summaryDto;
    }

}
