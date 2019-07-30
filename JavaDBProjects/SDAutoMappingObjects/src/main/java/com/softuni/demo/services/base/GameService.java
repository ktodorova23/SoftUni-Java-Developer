package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.GameAddDto;
import com.softuni.demo.domain.dtos.GameCommonView;
import com.softuni.demo.domain.dtos.GameDetailDto;
import com.softuni.demo.domain.dtos.GameTitleDto;

import java.util.List;
import java.util.Map;

public interface GameService {
    String addGame(GameAddDto gameAddDto);

    String editGame(int id, Map<String, String> data);

    String deleteGame(int id);

    List<GameCommonView> getAllGamesInfo();

    GameDetailDto getDetailedInformation(String param);

    List<GameTitleDto> getOwnedGames();
}
