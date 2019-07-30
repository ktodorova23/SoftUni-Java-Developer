package app.ccb.domain.dtos.importDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "bank-accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountRootSeedDto {

    @XmlElement(name = "bank-account")
    private List<BankAccountSeedDto> bankAccounts;

    public BankAccountRootSeedDto() {}

    public List<BankAccountSeedDto> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccountSeedDto> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
