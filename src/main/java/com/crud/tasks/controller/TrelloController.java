package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("/boards/{withLists}")
    public void getTrelloBoards(@PathVariable("withLists") boolean withLists) {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards(withLists).stream()
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
                .collect(Collectors.toList());

        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
            if (withLists) {
                System.out.println("This board contains lists: ");
                trelloBoardDto.getLists().forEach(trelloList ->
                        System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - "
                                + trelloList.isClosed()));
            }
        });
    }
}
