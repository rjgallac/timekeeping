package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("day")
public class DayController {

    @Autowired
    private DayService dayService;

    @GetMapping
    public DayDto get(@RequestParam String startDate){
        LocalDate date = LocalDate.parse(startDate);
        DayDto day = dayService.getDay(date);
        return day;
    }

    @PostMapping
    public DayDto add(@RequestBody DayDto dayDto){
        DayDto save = dayService.save(dayDto);
        return save;
    }

    @PutMapping("/{id}")
    public DayDto put(@PathVariable String id, @RequestBody DayDto dayDto){
        DayDto put = dayService.put(dayDto, id);
        return put;
    }

    @DeleteMapping("/{id}")
    public DayDto delete(@PathVariable String id){
        DayDto delete = dayService.delete(id);
        return delete;
    }

}
