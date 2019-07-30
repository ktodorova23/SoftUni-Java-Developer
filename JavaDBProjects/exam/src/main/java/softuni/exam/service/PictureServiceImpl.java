package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.importDtos.PictureDto;
import softuni.exam.domain.dtos.importDtos.PictureRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.Constants;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository,
                              FileUtil fileUtil,
                              XmlParser xmlParser,
                              ModelMapper modelMapper,
                              ValidatorUtil validatorUtil) {
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importPictures() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        PictureRootDto pictureRootDto = this.xmlParser.parseXml(PictureRootDto.class, Constants.PICTURES_XML_IMPORT_FILE_PATH);

        for (PictureDto picture : pictureRootDto.getPictures()) {
            Picture entity = this.modelMapper.map(picture, Picture.class);

            if (!this.validatorUtil.isValid(entity)) {
                sb.append(String.format(Constants.INCORRECT_DATA_ENTITY_MESSAGE, entity.getClass().getSimpleName().toLowerCase()))
                        .append(System.lineSeparator());

                continue;
            }

            this.pictureRepository.saveAndFlush(entity);
            sb.append(String.format(Constants.SUCCESSFUL_DATA_ENTITY_IMPORT_MESSAGE,
                    entity.getClass().getSimpleName().toLowerCase(),
                    entity.getUrl()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return this.fileUtil.readFile(Constants.PICTURES_XML_IMPORT_FILE_PATH);
    }

}
