package app.ccb.services;

import app.ccb.domain.dtos.importDtos.CardRootSeedDto;
import app.ccb.domain.dtos.importDtos.CardSeedDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Card;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.CardRepository;
import app.ccb.util.Constants;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import app.ccb.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final BankAccountRepository bankAccountRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, BankAccountRepository bankAccountRepository, FileUtil fileUtil, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.cardRepository = cardRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean cardsAreImported() {
        return this.cardRepository.count() != 0;
    }

    @Override
    public String readCardsXmlFile() throws IOException {
        return this.fileUtil.readFile(Constants.CARDS_IMPORT_XML_FILE_PATH);
    }

    @Override
    public String importCards() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        CardRootSeedDto cardRootSeedDto = this.xmlParser.parseXml(CardRootSeedDto.class, Constants.CARDS_IMPORT_XML_FILE_PATH);

        for (CardSeedDto dto : cardRootSeedDto.getCards()) {
            Card entity = this.modelMapper.map(dto, Card.class);

            BankAccount bankAccount = this.bankAccountRepository.findBankAccountByAccountNumber(dto.getAccountNumber());
            entity.setBankAccount(bankAccount);

            if (!this.validationUtil.isValid(entity)) {
                sb.append(Constants.INCORECT_DATA_MESSAGE).append(System.lineSeparator());
            } else {
                sb.append(String.format(Constants.SUCCESSFUL_DATA_IMPORT_MESSAGE, entity.getClass().getSimpleName(), entity.getCardNumber()))
                        .append(System.lineSeparator());
                this.cardRepository.saveAndFlush(entity);
            }
        }

        return sb.toString().trim();
    }
}
