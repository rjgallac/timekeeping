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

    @Autowired
    private SummaryService summaryService;

    @GetMapping
    public DayDto get(@RequestParam String startDate){
        LocalDate date = LocalDate.parse(startDate);
        SummaryDto summaryDto = summaryService.weekTotals();
        DayDto day = dayService.getDay(date);
        day.setSummaryDto(summaryDto);
        return day;
    }

    @PostMapping
    public DayDto add(@RequestBody DayDto dayDto){
        DayDto save = dayService.save(dayDto);
        SummaryDto summaryDto = summaryService.weekTotals();
        save.setSummaryDto(summaryDto);
        return save;
    }

    @PutMapping("/{id}")
    public DayDto put(@PathVariable String id, @RequestBody DayDto dayDto){
        DayDto put = dayService.put(dayDto, id);
        SummaryDto summaryDto = summaryService.weekTotals();
        put.setSummaryDto(summaryDto);
        return put;
    }

    @DeleteMapping("/{id}")
    public DayDto delete(@PathVariable String id){
        DayDto delete = dayService.delete(id);
        SummaryDto summaryDto = summaryService.weekTotals();
        delete.setSummaryDto(summaryDto);
        return delete;
    }

}
