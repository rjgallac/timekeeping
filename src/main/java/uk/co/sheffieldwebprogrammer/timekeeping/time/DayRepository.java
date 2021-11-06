package uk.co.sheffieldwebprogrammer.timekeeping.time;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

interface DayRepository extends MongoRepository<Day, String> {
    Day findFirstByDate(LocalDate date);
}
