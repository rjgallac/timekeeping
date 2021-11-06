package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeekService {
    @Autowired
    private DayService dayService;

    public List<DayDto> getWeek(LocalDate date){
        List<DayDto> days = new ArrayList<>();
        for(int i=0; i<5; i++){
            DayDto dayDto = dayService.getDay(date);
            days.add(dayDto);
            date=date.plusDays(1L);
        }
        return days;
    }
}
