package com.crud.tasks.trello.client;


import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrelloClient {

    private final RestTemplate restTemplate;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.api.key}")
    private String trelloAppKey;
    @Value("${trello.api.token}")
    private String trelloToken;
    @Value("${trello.api.username}")
    private String trelloUsername;

    private URI getUri(boolean withLists) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards");
        builder.queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id");
        if (withLists) {
            builder.queryParam("lists", "all");
        }

        return builder.build()
                .encode()
                .toUri();
    }

    public List<TrelloBoardDto> getTrelloBoards(boolean withLists) {
            TrelloBoardDto[] boardsResponse = restTemplate.getForObject(getUri(withLists), TrelloBoardDto[].class);
        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
