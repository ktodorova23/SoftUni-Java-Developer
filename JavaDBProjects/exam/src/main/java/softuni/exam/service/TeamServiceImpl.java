package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.importDtos.TeamDto;
import softuni.exam.domain.dtos.importDtos.TeamRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.Constants;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository,
                           PictureRepository pictureRepository,
                           FileUtil fileUtil, XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidatorUtil validatorUtil) {
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importTeams() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        TeamRootDto teamRootDto = this.xmlParser.parseXml(TeamRootDto.class, Constants.TEAMS_XML_IMPORT_FILE_PATH);

        for (TeamDto team : teamRootDto.getTeams()) {
            Team entity = this.modelMapper.map(team, Team.class);
            Picture picture = this.pictureRepository.findPictureByUrl(team.getPicture().getUrl());

            entity.setPicture(picture);

            if (!this.validatorUtil.isValid(entity)) {
                sb.append(String.format(Constants.INCORRECT_DATA_ENTITY_MESSAGE, entity.getClass().getSimpleName().toLowerCase()))
                        .append(System.lineSeparator());

                continue;
            }

            this.teamRepository.saveAndFlush(entity);
            sb.append(String.format(Constants.SUCCESSFUL_DATA_ENTITY_IMPORT_MESSAGE, entity.getClass().getSimpleName().toLowerCase(),
                    entity.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return this.fileUtil.readFile(Constants.TEAMS_XML_IMPORT_FILE_PATH);
    }
}
