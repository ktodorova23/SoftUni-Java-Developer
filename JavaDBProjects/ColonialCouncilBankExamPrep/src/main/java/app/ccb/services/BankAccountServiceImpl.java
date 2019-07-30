package app.ccb.services;

import app.ccb.domain.dtos.importDtos.BankAccountRootSeedDto;
import app.ccb.domain.dtos.importDtos.BankAccountSeedDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Client;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.ClientRepository;
import app.ccb.util.Constants;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import app.ccb.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final ClientRepository clientRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, ClientRepository clientRepository, FileUtil fileUtil, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.bankAccountRepository = bankAccountRepository;
        this.clientRepository = clientRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean bankAccountsAreImported() {
        return this.bankAccountRepository.count() != 0;
    }

    @Override
    public String readBankAccountsXmlFile() throws IOException {
        return this.fileUtil.readFile(Constants.BANK_ACCOUNTS_IMPORT_XML_FILE_PATH);
    }

    @Override
    public String importBankAccounts() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        BankAccountRootSeedDto bankAccountRootSeedDto = this.xmlParser.parseXml(BankAccountRootSeedDto.class,
                Constants.BANK_ACCOUNTS_IMPORT_XML_FILE_PATH);

        for (BankAccountSeedDto dto : bankAccountRootSeedDto.getBankAccounts()) {
            BankAccount entity = this.modelMapper.map(dto, BankAccount.class);

            Client client = this.clientRepository.findClientByFullName(dto.getClient());
            entity.setClient(client);

            if (!this.validationUtil.isValid(entity)) {
                sb.append(Constants.INCORECT_DATA_MESSAGE).append(System.lineSeparator());
            } else {
                sb.append(String.format(Constants.SUCCESSFUL_DATA_IMPORT_MESSAGE, entity.getClass().getSimpleName(), entity.getAccountNumber()))
                        .append(System.lineSeparator());
                this.bankAccountRepository.saveAndFlush(entity);
            }
        }

        return sb.toString().trim();
    }
}
