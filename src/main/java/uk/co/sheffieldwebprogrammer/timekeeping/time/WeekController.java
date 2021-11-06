package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("week")
public class WeekController {

    @Autowired
    private WeekService weekService;

    @GetMapping
    public List<DayDto> get(@RequestParam String startDate){
        LocalDate date = LocalDate.parse(startDate);
        return weekService.getWeek(date);
    }


}
