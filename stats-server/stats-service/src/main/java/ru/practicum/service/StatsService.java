package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.mapper.HitMapper;
import ru.practicum.model.Hit;
import ru.practicum.model.hit.dto.GetHitDto;
import ru.practicum.model.hit.dto.PostHitDto;
import ru.practicum.repository.StatsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public void postHit(PostHitDto postHitDto) {
        Hit hit = HitMapper.toHit(postHitDto);
        statsRepository.save(hit);
    }

    public List<GetHitDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        List<GetHitDto> result;
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
