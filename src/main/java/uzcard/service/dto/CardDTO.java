package uzcard.service.dto;

import uzcard.domain.Card;
import uzcard.domain.enumeration.CardStatus;
import uzcard.domain.enumeration.CardType;
import uzcard.service.dto.ClientDTO;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link Card} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CardDTO implements Serializable {

    private UUID id;

    private String name;

    private Long cardBalance;

    private LocalDate cardExpiredDate;

    private LocalDate cardCreateDate;

    private String cardToken;

    private CardType cardType;

    private CardStatus cardStatus;

    @NotNull
    private ClientDTO client;

    @NotNull
    private BankDTO bank;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Long cardBalance) {
        this.cardBalance = cardBalance;
    }

    public LocalDate getCardExpiredDate() {
        return cardExpiredDate;
    }

    public void setCardExpiredDate(LocalDate cardExpiredDate) {
        this.cardExpiredDate = cardExpiredDate;
    }

    public LocalDate getCardCreateDate() {
        return cardCreateDate;
    }

    public void setCardCreateDate(LocalDate cardCreateDate) {
        this.cardCreateDate = cardCreateDate;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CardDTO)) {
            return false;
        }

        CardDTO cardDTO = (CardDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cardDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CardDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", cardBalance=" + getCardBalance() +
            ", cardExpiredDate='" + getCardExpiredDate() + "'" +
            ", cardCreateDate='" + getCardCreateDate() + "'" +
            ", cardToken='" + getCardToken() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", cardStatus='" + getCardStatus() + "'" +
            ", client=" + getClient() +
            ", bank=" + getBank() +
            "}";
    }
}
