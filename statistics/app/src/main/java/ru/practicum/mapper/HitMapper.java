package ru.practicum.mapper;

import org.mapstruct.Mapper;
import ru.practicum.model.Hit;
import ru.practicum.statistics.api.dto.HitDto;

@Mapper
public interface HitMapper {

    Hit dtoToEntity(HitDto hitDto);
}
