package ru.practicum.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.model.Hit;
import ru.practicum.model.hit.dto.PostHitDto;

@UtilityClass
public class HitMapper {

    public Hit toHit(PostHitDto postHitDto) {
        return new Hit(
                postHitDto.getUri(),
                postHitDto.getIp(),
                postHitDto.getApp(),
                postHitDto.getDate());
    }

}
