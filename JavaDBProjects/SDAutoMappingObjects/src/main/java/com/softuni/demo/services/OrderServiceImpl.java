package com.softuni.demo.services;

import com.softuni.demo.domain.dtos.GameTitleDto;
import com.softuni.demo.domain.entities.Game;
import com.softuni.demo.domain.entities.Order;
import com.softuni.demo.domain.entities.User;
import com.softuni.demo.domain.enums.Status;
import com.softuni.demo.repositories.GameRepository;
import com.softuni.demo.repositories.OrderRepository;
import com.softuni.demo.repositories.UserRepository;
import com.softuni.demo.services.base.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(UserRepository userRepository, GameRepository gameRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public String addGameToCart(GameTitleDto gameTitleDto) {
        StringBuilder sb = new StringBuilder();

        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            return sb.append("There is no logged in user!").toString();
        }

        User currentlyLoggedIn = this.userRepository.findByEmail(UserServiceImpl.loggedInEmail).orElse(null);

        Game game = this.gameRepository.findByTitle(gameTitleDto.getTitle()).orElse(null);

        if (game == null) {
            return sb.append("No game with this title in catalog!").toString();
        }

        if (currentlyLoggedIn.getGames().stream().anyMatch(g -> g.getTitle().equals(game.getTitle()))) {
            return sb.append("User already has this game").toString();
        }

        Order order;

        if (this.orderRepository.findByUserAndStatus(currentlyLoggedIn, Status.ACTIVE) == null) {
            order = new Order();
            order.setStatus(Status.ACTIVE);
        } else {
            order = this.orderRepository.findByUserAndStatus(currentlyLoggedIn, Status.ACTIVE);
        }

        if (order.getGames() == null) {
            order.setGames(List.of(game));
        } else if (order.getGames().stream().anyMatch(g -> g.getTitle().equals(game.getTitle()))) {
            return sb.append("Game is already in shopping cart").toString();
        } else {
            order.getGames().add(game);
        }

        order.setUser(currentlyLoggedIn);

        this.gameRepository.saveAndFlush(game);
        this.userRepository.saveAndFlush(currentlyLoggedIn);
        this.orderRepository.saveAndFlush(order);

        return sb.append(String.format("%s added to cart.", game.getTitle())).toString();
    }

    @Override
    public String removeFromCart(GameTitleDto gameTitleDto) {
        StringBuilder sb = new StringBuilder();

        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            return sb.append("There is no logged in user!").toString();
        }

        User currentlyLoggedIn = this.userRepository.findByEmail(UserServiceImpl.loggedInEmail).orElse(null);

        Game game = this.gameRepository.findByTitle(gameTitleDto.getTitle()).orElse(null);

        Order order = this.orderRepository.findByUserAndStatus(currentlyLoggedIn, Status.ACTIVE);

        if (order == null) {
            return sb.append("There is no current active order for this user!").toString();
        }

        if (game == null) {
            return sb.append("No game with this title in catalog!").toString();
        }

        boolean isGameInCart = order.getGames().stream().anyMatch(g -> g.getTitle().equals(game.getTitle()));

        if (isGameInCart) {
            Game gameInCart = order.getGames().stream().filter(g -> g.getTitle().equals(game.getTitle())).findFirst().get();
            order.getGames().remove(gameInCart);
            this.orderRepository.saveAndFlush(order);
        } else {
            return sb.append("Game with this title is not currently in cart!").toString();
        }

        return sb.append(String.format("%s removed from cart.", game.getTitle())).toString();
    }

    @Override
    public String buyItems() {
        StringBuilder sb = new StringBuilder();

        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            return sb.append("There is no logged in user!").toString();
        }

        User currentlyLoggedIn = this.userRepository.findByEmail(UserServiceImpl.loggedInEmail).orElse(null);

        Order order = this.orderRepository.findByUserAndStatus(currentlyLoggedIn, Status.ACTIVE);

        if (order.getGames().isEmpty()) {
            return sb.append("No games in cart!").toString();
        }

        sb.append("Successfully bought games:").append(System.lineSeparator());

        for (Game game : order.getGames()) {
            sb.append(String.format(" -%s%n", game.getTitle()));
            currentlyLoggedIn.getGames().add(game);
        }
        order.getGames().clear();

        //TODO: Does not change the status of the order upon completion!
        order.setStatus(Status.CLOSED);

        this.orderRepository.saveAndFlush(order);

        this.userRepository.saveAndFlush(currentlyLoggedIn);


        return sb.toString().trim();
    }
}
