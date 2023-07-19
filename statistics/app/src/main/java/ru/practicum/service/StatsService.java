package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.mapper.HitMapper;
import ru.practicum.model.Hit;
import ru.practicum.repository.StatsRepository;
import ru.practicum.statistics.api.dto.HitDto;
import ru.practicum.statistics.api.dto.ViewHitStats;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;
    private final HitMapper mapper;

    public void postHit(HitDto hitDto) {
        Hit hit = mapper.dtoToEntity(hitDto);
        statsRepository.save(hit);
    }

    public List<ViewHitStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        List<ViewHitStats> result;
        if (unique) {
            if (uris == null) {
                result = statsRepository.getUniqueStats(start, end);
            } else {
                result = statsRepository.getUniqueStatsByUris(start, end, uris);
            }
        } else if (uris == null) {
            result = statsRepository.getStats(start, end);
        } else
            result = statsRepository.getStatsByUris(start, end, uris);
        return result;
    }

}
