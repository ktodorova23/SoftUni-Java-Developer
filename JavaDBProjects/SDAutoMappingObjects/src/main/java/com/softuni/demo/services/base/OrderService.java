package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.GameTitleDto;

public interface OrderService {
    String addGameToCart(GameTitleDto gameTitleDto);

    String removeFromCart(GameTitleDto gameTitleDto);

    String buyItems();
}
