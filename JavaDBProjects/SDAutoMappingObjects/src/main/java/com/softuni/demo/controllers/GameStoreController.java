package com.softuni.demo.controllers;

import com.softuni.demo.domain.dtos.*;
import com.softuni.demo.services.base.GameService;
import com.softuni.demo.services.base.OrderService;
import com.softuni.demo.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GameStoreController implements CommandLineRunner {
    private final BufferedReader reader;

    private final UserService userService;
    private final GameService gameService;
    private final OrderService orderService;

    @Autowired
    public GameStoreController(BufferedReader reader, UserService userService, GameService gameService, OrderService orderService) {
        this.reader = reader;
        this.userService = userService;
        this.gameService = gameService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            String[] params = this.reader.readLine().split("\\|");

            if (params[0].contains("Register")) {
                StringBuilder sb = new StringBuilder();
                // In order to check if the input is correctly entered and the confirmed password matches the main one!!!
                UserRegistrationDto userRegistrationDto = null;
                try {
                     userRegistrationDto = new UserRegistrationDto(params[1],
                            params[2], params[3], params[4]);
                } catch (IllegalCallerException ex) {
                    sb.append(ex.getMessage());
                }

                // In case everything is correctly entered:
                if (userRegistrationDto != null) {
                    sb.append(this.userService.registerUser(userRegistrationDto));
                }
                System.out.println(sb.toString());
            } else if (params[0].contains("Login")) {
                StringBuilder sb = new StringBuilder();
                UserLoginDto userLoginDto = new UserLoginDto(params[1], params[2]);
                sb.append(this.userService.loginUser(userLoginDto));
                System.out.println(sb.toString());
            } else if (params[0].contains("Logout")) {
                System.out.println(this.userService.logoutUser());
            } else if (params[0].contains("AddGame")) {
                GameAddDto gameAddDto = new GameAddDto(params[1], new BigDecimal(params[2]),
                        Double.parseDouble(params[3]), params[4], params[5], params[6],
                        LocalDate.parse(params[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));

                System.out.println(this.gameService.addGame(gameAddDto));
            } else if (params[0].contains("Edit")) {
                System.out.println(this.gameService.editGame(Integer.parseInt(params[1]), getAllParams(params)));
            } else if (params[0].contains("Delete")) {
                System.out.println(this.gameService.deleteGame(Integer.parseInt(params[1])));
            } else if (params[0].contains("All")) {
                if (this.gameService.getAllGamesInfo().size() == 0) {
                    System.out.println("There are no added games to the catalog!");
                } else {
                    this.gameService.getAllGamesInfo()
                            .forEach(game -> System.out.println(String.format("%s %s", game.getTitle(), game.getPrice())));
                }
            } else if (params[0].contains("Detail")) {
                GameDetailDto gameDetailDto = this.gameService.getDetailedInformation(params[1]);

                if (gameDetailDto == null) {
                    System.out.println("There is no game with given title in the catalog!");
                } else {
                    System.out.println(String.format("Title: %s%nPrice: %s%nDescription: %s%nRelease date: %s",
                            gameDetailDto.getTitle(),
                            gameDetailDto.getPrice(),
                            gameDetailDto.getDescription(),
                            gameDetailDto.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                }
            } else if (params[0].contains("OwnedGames")) {
                if (this.gameService.getOwnedGames().size() == 0) {
                    System.out.println("No games are currently owned!");
                } else {
                    this.gameService.getOwnedGames().forEach(g -> System.out.println(g.getTitle()));
                }
            } else if (params[0].contains("AddItem")) {
                GameTitleDto gameTitleDto = new GameTitleDto(params[1]);
                System.out.println(this.orderService.addGameToCart(gameTitleDto));
            } else if (params[0].contains("Remove")) {
                GameTitleDto gameTitleDto = new GameTitleDto(params[1]);
                System.out.println(this.orderService.removeFromCart(gameTitleDto));
            } else if (params[0].contains("Buy")) {
                System.out.println(this.orderService.buyItems());
            } else if (params[0].equals("Stop")) {
                break;
            }
        }
    }

    private Map<String, String> getAllParams(String[] params) {
        Map<String, String> data = new HashMap<>();

        for (int i = 2; i < params.length; i++) {
            String[] currentParameter = params[i].split("=");

            data.put(currentParameter[0], currentParameter[1]);
        }
        return data;
    }
}
