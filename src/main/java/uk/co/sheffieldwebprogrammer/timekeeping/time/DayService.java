package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Optional;

@Service
public class DayService {

    @Autowired
    private DayRepository dayRepository;

    public DayDto getDay(LocalDate date){
        Day day = dayRepository.findFirstByDate(date);
        DayDto dayDto;
        if(day != null){
            dayDto = new DayDto(day.getId(), day.getDate(), day.getStartAm(), day.getEndAm(), day.getStartPm(), day.getEndPm(), day.getNotes());
        }else{
            dayDto = new DayDto("", date, LocalTime.of(8, 30), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0), "");
        }

        return dayDto;
    }

    @CacheEvict(value = "summary")
    public DayDto save(DayDto dayDto){
        Day entity = new Day(dayDto.getDate(), dayDto.getStartAm(), dayDto.getEndAm(), dayDto.getStartPm(), dayDto.getEndPm(), dayDto.getNotes());
        Day save = dayRepository.save(entity);
        dayDto = new DayDto("", save.getDate(), LocalTime.of(8, 30), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0), "");
        return dayDto;
    }

    public DayDto put(DayDto dayDto, String id){
        Optional<Day> byId = dayRepository.findById(id);
        if(byId.isPresent()){
            Day day = byId.get();
            day.setDate(dayDto.getDate());
            day.setStartAm(dayDto.getStartAm());
            day.setEndAm(dayDto.getEndAm());
            day.setStartPm(dayDto.getStartPm());
            day.setEndPm(dayDto.getEndPm());
            day.setNotes(dayDto.getNotes());
            Day save = dayRepository.save(day);
            dayDto = new DayDto("", save.getDate(), LocalTime.of(8, 30), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0), "");
            return dayDto;
        }
        return null;

    }

    public DayDto delete(String id) {
        Optional<Day> byId = dayRepository.findById(id);
        dayRepository.deleteById(id);
        DayDto dayDto = new DayDto("", LocalDate.now(), LocalTime.of(8, 30), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0), "");
        return dayDto;
    }

}
