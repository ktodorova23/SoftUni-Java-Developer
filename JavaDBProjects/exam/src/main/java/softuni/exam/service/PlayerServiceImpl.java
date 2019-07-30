package softuni.exam.service;

import com.google.gson.Gson;
import org.apache.tomcat.util.bcel.Const;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.importDtos.PlayerDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.enums.Position;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.Constants;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PictureRepository pictureRepository;
    private final TeamRepository teamRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository,
                             PictureRepository pictureRepository,
                             TeamRepository teamRepository,
                             FileUtil fileUtil, Gson gson,
                             ModelMapper modelMapper,
                             ValidatorUtil validatorUtil) {
        this.playerRepository = playerRepository;
        this.pictureRepository = pictureRepository;
        this.teamRepository = teamRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        PlayerDto[] playerDtos = this.gson.fromJson(this.readPlayersJsonFile(), PlayerDto[].class);

        for (PlayerDto dto : playerDtos) {
            Player entity = this.modelMapper.map(dto, Player.class);

            Picture picture = this.pictureRepository.findPictureByUrl(dto.getPicture().getUrl());
            Team team = this.teamRepository.findTeamByName(dto.getTeam().getName());

            entity.setPicture(picture);
            entity.setTeam(team);
            try {
                entity.setPosition(Position.valueOf(dto.getPosition()));
            } catch (Exception e) {
                entity.setPosition(null);
            }

            if (!this.validatorUtil.isValid(entity)) {
                sb.append(String.format(Constants.INCORRECT_DATA_ENTITY_MESSAGE, entity.getClass().getSimpleName().toLowerCase()))
                        .append(System.lineSeparator());

                continue;
            }

            this.playerRepository.saveAndFlush(entity);
            sb.append(String.format(Constants.SUCCESSFUL_DATA_ENTITY_IMPORT_MESSAGE,
                    entity.getClass().getSimpleName().toLowerCase(),
                    entity.getFirstName() + " " + entity.getLastName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return this.fileUtil.readFile(Constants.PLAYERS_JSON_IMPORT_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        List<Player> allPlayers = this.playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000));

        for (Player player : allPlayers) {
            sb.append(String.format(Constants.PLAYER_WITH_SALARY_GREATER_THAN_AMOUNT_INFO,
                    player.getFirstName(),
                    player.getLastName(),
                    player.getNumber(),
                    player.getSalary(),
                    player.getTeam().getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();

        Team team = this.teamRepository.findTeamByName("North Hub");

        sb.append(String.format("Team %s", team.getName())).append(System.lineSeparator());
        team.getPlayers().forEach(t -> sb.append(String.format(Constants.PLAYERS_FROM_NORTH_HUB_INFO,
                t.getFirstName(),
                t.getLastName(),
                t.getPosition().toString(),
                t.getNumber()))
                .append(System.lineSeparator()));
        return sb.toString();
    }
}
