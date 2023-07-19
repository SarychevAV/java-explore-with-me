package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practicum.service.StatsService;
import ru.practicum.statistics.api.StatsApi;
import ru.practicum.statistics.api.dto.ViewHitStats;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatsController implements StatsApi {

    private final StatsService statsService;

    @Override
    public ResponseEntity<List<ViewHitStats>> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        return ResponseEntity.ok(statsService.getStats(start, end, uris, unique));
    }
}
