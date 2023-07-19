package ru.practicum.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import ru.practicum.model.hit.dto.GetHitDto;
import ru.practicum.model.hit.dto.PostHitDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class StatsClient {

    private static final String SERVER_URL = "http://localhost:9090";
    private final RestTemplate restTemplate;

    public StatsClient() {
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }

    public void postHit(PostHitDto postHitDto) {
        String url = SERVER_URL + "/hit";
        restTemplate.postForEntity(url, postHitDto, Void.class);
    }

    public List<GetHitDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        String url = SERVER_URL + "/stats?start={start}&end={end}&uris={uris}&unique={unique}";
        ResponseEntity<List<GetHitDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                },
                Map.of("start", start, "end", end, "uris", uris, "unique", unique)
        );
        return responseEntity.getBody();
    }

}
