package ru.kirillalexeev.clock.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kirillalexeev.clock.api.TimeDto;
import ru.kirillalexeev.clock.service.CurrentTimeService;

@RestController
@RequestMapping("/time")
public class TimeController {
    private final CurrentTimeService currentTimeService;

    public TimeController(CurrentTimeService currentTimeService) {
        this.currentTimeService = currentTimeService;
    }

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeDto> getTime() {
        return ResponseEntity.ok().body(new TimeDto(currentTimeService.getTime()));
    }
}
