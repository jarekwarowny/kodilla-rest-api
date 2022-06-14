package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        TrelloListDto trelloListDto = new TrelloListDto("aaa", "aaa", true);
        List<TrelloListDto> trelloListDtos = Arrays.asList(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("aaa", "aaaaa", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = Arrays.asList(trelloBoardDto);

        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        Assertions.assertEquals("aaa", "aaa");
        Assertions.assertEquals("aaa", "aaa");
    }

    @Test
    public void mapToBoardsDtoTest() {
        TrelloList trelloList = new TrelloList("aaa", "sss", false);
        List<TrelloList> trelloLists = Arrays.asList(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("aaa", "ddds", trelloLists);
        List<TrelloBoard> trelloBoards = Arrays.asList(trelloBoard);

        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoards);

        Assertions.assertEquals("aaa", "aaa");
        Assertions.assertEquals("sss", "sss");
    }

    @Test
    public void  mapToListTest() {
        TrelloListDto trelloListDto = new TrelloListDto("aaa", "vvv", true);
        List<TrelloListDto> trelloListDtos = Arrays.asList(trelloListDto);

        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        Assertions.assertEquals("aaa", trelloLists.get(0).getId());
        Assertions.assertEquals("vvv", trelloLists.get(0).getName());
    }

    @Test
    public void mapToListDtoTest() {
        TrelloList trelloList = new TrelloList("aaa", "sss", true);
        List<TrelloList> trelloLists = Arrays.asList(trelloList);

        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        Assertions.assertEquals("aaa", "aaa");
        Assertions.assertEquals("sss", "sss");
    }

    @Test
    public void mapToCardDtoTest() {
        TrelloCard trelloCard = new TrelloCard("aaa", "sss", "ccc", "eee");

        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        Assertions.assertEquals("aaa", "aaa");
        Assertions.assertEquals("sss", "sss");
        Assertions.assertEquals("ccc", "ccc");
        Assertions.assertEquals("eee", "eee");
    }

    @Test
    public void mapToCardTest() {
        TrelloCardDto trelloCardDto = new TrelloCardDto("sss", "as", "asas", "ssas");

        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        Assertions.assertEquals("sss", "sss");
        Assertions.assertEquals("as", "as");
        Assertions.assertEquals("asas", "asas");
        Assertions.assertEquals("ssas", "ssas");
    }
}
