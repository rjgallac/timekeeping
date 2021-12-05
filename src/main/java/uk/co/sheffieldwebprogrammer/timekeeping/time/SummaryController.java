package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @GetMapping
    public SummaryDto get(){
        SummaryDto summaryDto = summaryService.weekTotals();
        return summaryDto;
    }
}
