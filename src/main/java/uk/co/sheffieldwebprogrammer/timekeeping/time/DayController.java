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
        return dayService.getDay(date);
    }

    @PostMapping
    public void add(@RequestBody DayDto dayDto){
        dayService.save(dayDto);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable String id, @RequestBody DayDto dayDto){
        dayService.put(dayDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        dayService.delete(id);
    }

}
