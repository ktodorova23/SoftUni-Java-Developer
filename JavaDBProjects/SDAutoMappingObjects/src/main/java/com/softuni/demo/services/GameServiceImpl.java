package com.softuni.demo.services;

import com.softuni.demo.domain.dtos.GameAddDto;
import com.softuni.demo.domain.dtos.GameCommonView;
import com.softuni.demo.domain.dtos.GameDetailDto;
import com.softuni.demo.domain.dtos.GameTitleDto;
import com.softuni.demo.domain.entities.Game;
import com.softuni.demo.domain.entities.User;
import com.softuni.demo.domain.enums.Role;
import com.softuni.demo.repositories.GameRepository;
import com.softuni.demo.repositories.UserRepository;
import com.softuni.demo.services.base.GameService;
import com.softuni.demo.services.base.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, UserService userService, ModelMapper mapper) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = mapper;
    }

    @Override
    public String addGame(GameAddDto gameAddDto) {
        StringBuilder sb = new StringBuilder();

        //Checks if there is user currently logged in
        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            return sb.append("There is no user currently logged in!").toString();
        }

        //Necessary in order to check the role of the user who is currently logged in
        User currentlyLoggedInUser = this.userService.findByEmail(UserServiceImpl.loggedInEmail);

        if (currentlyLoggedInUser.getRole().equals(Role.ADMIN)) {
            Game game = this.modelMapper.map(gameAddDto, Game.class);

            //Validate if game is already added!
            Game inDB = this.gameRepository.findByTitle(game.getTitle()).orElse(null);

            if (inDB == null) {
                ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
                Validator validator = vf.getValidator();

                Set<ConstraintViolation<Game>> violations = validator.validate(game);

                if (violations.size() == 0) {
                    this.gameRepository.saveAndFlush(game);
//                    currentlyLoggedInUser.getGames().add(game);
//                    this.userRepository.saveAndFlush(currentlyLoggedInUser);
                    sb.append(String.format("Added %s", game.getTitle()));
                } else {
                    for (ConstraintViolation<Game> violation : violations) {
                        sb.append(violation.getMessage()).append(System.lineSeparator());
                    }
                }
            } else {
                sb.append("This game is already present in the catalog!");
            }
        } else {
            sb.append("Only admin can add games to the catalog!");
        }

        return sb.toString();
    }

    @Override
    public String editGame(int id, Map<String, String> data) {
        StringBuilder sb = new StringBuilder();

        //Checks if there is user currently logged in
        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            return sb.append("There is no user currently logged in!").toString();
        }

        //Necessary in order to check the role of the user who is currently logged in
        User currentlyLoggedInUser = this.userService.findByEmail(UserServiceImpl.loggedInEmail);

        if (currentlyLoggedInUser.getRole().equals(Role.ADMIN)) {
            //Validate if game is already added!
            Game game = this.gameRepository.findById(id).orElse(null);

            if (game == null) {
                sb.append("No game with given id in catalog!");
            } else {
                for (Map.Entry<String, String> param : data.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();

                    if (key.equals("trailer")) {
                        if (value.length() != 11) {
                            return sb.append("Incorrect trailer length! Cannot update game info!").toString();
                        } else {
                            game.setTrailer(value);
                        }
                    } else if (key.contains("image")) {
                        game.setImageThumbnail(value);
                    } else if (key.equals("size")) {
                        if (Double.parseDouble(value) > 0) {
                            game.setSize(Double.parseDouble(value));
                        } else {
                            return sb.append("Size cannot be a negative value! Cannot update game info!").toString();
                        }
                    } else if (key.equals("price")) {
                        if (new BigDecimal(value).compareTo(BigDecimal.ZERO) > 0) {
                            game.setPrice(new BigDecimal(value));
                        } else {
                            return sb.append("Price cannot be a negative number! Cannot update game info!").toString();
                        }
                    } else if (key.equals("description")) {
                        if (value.length() >= 20 && value.length() <= 1000) {
                            game.setDescription(value);
                        } else {
                            return sb.append("Incorrect length of description. Must be between 20 and 1000 symbols long! Cannot update game info!").toString();
                        }
                    } else if (key.contains("release")) {
                        game.setReleaseDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    }
                }

                this.gameRepository.saveAndFlush(game);
                sb.append(String.format("Edited %s", game.getTitle()));
            }
        } else {
            sb.append("Only admin can edit games from the catalog!");
        }

        return sb.toString();
    }

    @Override
    public String deleteGame(int id) {
        StringBuilder sb = new StringBuilder();

        //Checks if there is user currently logged in
        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            return sb.append("There is no user currently logged in!").toString();
        }

        //Necessary in order to check the role of the user who is currently logged in
        User currentlyLoggedInUser = this.userService.findByEmail(UserServiceImpl.loggedInEmail);

        if (currentlyLoggedInUser.getRole().equals(Role.ADMIN)) {
            //Validate if game is already added!
            Game game = this.gameRepository.findById(id).orElse(null);

            if (game == null) {
                sb.append("No game with given id in catalog!");
            } else {
                String gameTitle = game.getTitle();
                //To prevent losing the users from DB...
                for (User user : game.getUsers()) {
                    Set<Game> userGames = user.getGames();
                    userGames.remove(game);
                    user.setGames(userGames);
                    this.userRepository.saveAndFlush(user);
                }
                game.setUsers(null);
                this.gameRepository.deleteById(id);
                sb.append(String.format("Deleted %s", gameTitle));
            }
        } else {
            sb.append("Only admin can delete games from the catalog!");
        }
        return sb.toString();
    }

    @Override
    public List<GameCommonView> getAllGamesInfo() {
        List<Game> allGames = this.gameRepository.findAll();

        List<GameCommonView> allGamesView = new ArrayList<>();
        for (Game game : allGames) {
            GameCommonView gameCommonView = this.modelMapper.map(game, GameCommonView.class);
            allGamesView.add(gameCommonView);
        }

        return allGamesView;
    }

    @Override
    public GameDetailDto getDetailedInformation(String gameTitle) {
        Game game = this.gameRepository.findByTitle(gameTitle).orElse(null);
        if (game == null) {
            return null;
        }

        return this.modelMapper.map(game, GameDetailDto.class);
    }

    @Override
    public List<GameTitleDto> getOwnedGames() {
        List<GameTitleDto> ownedGames = new ArrayList<>();

        List<Game> allGames = this.gameRepository.findAll();

        for (Game game : allGames) {
            GameTitleDto gameTitleDto = this.modelMapper.map(game, GameTitleDto.class);
            ownedGames.add(gameTitleDto);
        }
        return ownedGames;
    }
}
