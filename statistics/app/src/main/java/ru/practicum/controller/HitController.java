package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.service.StatsService;
import ru.practicum.statistics.api.HitApi;
import ru.practicum.statistics.api.dto.HitDto;

@RestController
@RequiredArgsConstructor
public class HitController implements HitApi {

    private final StatsService statsService;

    public ResponseEntity<Void> hit(@RequestBody HitDto hitDto) {
        statsService.postHit(hitDto);
        return ResponseEntity.ok().build();
    }
}
