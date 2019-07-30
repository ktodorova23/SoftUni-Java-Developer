package app.ccb.domain.dtos.importDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cards")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardRootSeedDto {

    @XmlElement(name = "card")
    private List<CardSeedDto> cards;

    public CardRootSeedDto() {}

    public List<CardSeedDto> getCards() {
        return cards;
    }

    public void setCards(List<CardSeedDto> cards) {
        this.cards = cards;
    }
}
