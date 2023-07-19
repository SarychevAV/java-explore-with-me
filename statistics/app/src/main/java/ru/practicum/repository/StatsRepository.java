package ru.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.model.Hit;
import ru.practicum.statistics.api.dto.ViewHitStats;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository extends JpaRepository<Hit, Long> {

    @Query("select new ru.practicum.statistics.api.dto.ViewHitStats(s.app, s.uri, count(s.ip))" +
            "from Hit as s " +
            "where s.date >= ?1 and s.date <= ?2 " +
            "group by s.app, s.uri")
    List<ViewHitStats> getStats(LocalDateTime start, LocalDateTime end);


    @Query("select new ru.practicum.statistics.api.dto.ViewHitStats(s.app, s.uri, count(distinct s.ip))" +
            "from Hit as s " +
            "where s.date >= ?1 and s.date <= ?2 " +
            "group by s.app, s.uri")
    List<ViewHitStats> getUniqueStats(LocalDateTime start, LocalDateTime end);

    @Query("select new ru.practicum.statistics.api.dto.ViewHitStats(s.app, s.uri, count(s.ip))" +
            "from Hit as s " +
            "where s.date >= ?1 and s.date <= ?2 and s.uri in ?3 " +
            "group by s.app, s.uri")
    List<ViewHitStats> getStatsByUris(LocalDateTime start, LocalDateTime end, List<String> uris);

    @Query("select new ru.practicum.statistics.api.dto.ViewHitStats(s.app, s.uri, count(distinct s.ip))" +
            "from Hit as s " +
            "where s.date >= ?1 and s.date <= ?2 and s.uri in ?3 " +
            "group by s.app, s.uri")
    List<ViewHitStats> getUniqueStatsByUris(LocalDateTime start, LocalDateTime end, List<String> uris);

}
