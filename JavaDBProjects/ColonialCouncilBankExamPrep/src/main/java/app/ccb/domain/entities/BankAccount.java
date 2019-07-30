package app.ccb.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity {
    @NotNull
    private String accountNumber;
    private BigDecimal balance;
    @NotNull
    @OneToOne(targetEntity = Client.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Client client;
    @OneToMany(targetEntity = Card.class, mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private List<Card> cards;

    public BankAccount() {}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
