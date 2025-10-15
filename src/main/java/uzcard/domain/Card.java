package uzcard.domain;


import uzcard.domain.Client;
import uzcard.domain.enumeration.CardStatus;
import uzcard.domain.enumeration.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * A Card.
 */
@Entity
@Table(name = "card")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "card_balance")
    private Long cardBalance;

    @Column(name = "card_expired_date")
    private LocalDate cardExpiredDate;

    @Column(name = "card_create_date")
    private LocalDate cardCreateDate;

    @Column(name = "card_token", unique = true)
    private String cardToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_status")
    private CardStatus cardStatus;

    @ManyToOne(optional = false)
    @NotNull
    private Client client;

    @ManyToOne(optional = false)
    @NotNull
    private Bank bank;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public UUID getId() {
        return this.id;
    }

    public Card id(UUID id) {
        this.setId(id);
        return this;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Card name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCardBalance() {
        return this.cardBalance;
    }

    public Card cardBalance(Long cardBalance) {
        this.setCardBalance(cardBalance);
        return this;
    }

    public void setCardBalance(Long cardBalance) {
        this.cardBalance = cardBalance;
    }

    public LocalDate getCardExpiredDate() {
        return this.cardExpiredDate;
    }

    public Card cardExpiredDate(LocalDate cardExpiredDate) {
        this.setCardExpiredDate(cardExpiredDate);
        return this;
    }

    public void setCardExpiredDate(LocalDate cardExpiredDate) {
        this.cardExpiredDate = cardExpiredDate;
    }

    public LocalDate getCardCreateDate() {
        return this.cardCreateDate;
    }

    public Card cardCreateDate(LocalDate cardCreateDate) {
        this.setCardCreateDate(cardCreateDate);
        return this;
    }

    public void setCardCreateDate(LocalDate cardCreateDate) {
        this.cardCreateDate = cardCreateDate;
    }

    public String getCardToken() {
        return this.cardToken;
    }

    public Card cardToken(String cardToken) {
        this.setCardToken(cardToken);
        return this;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public Card cardType(CardType cardType) {
        this.setCardType(cardType);
        return this;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardStatus getCardStatus() {
        return this.cardStatus;
    }

    public Card cardStatus(CardStatus cardStatus) {
        this.setCardStatus(cardStatus);
        return this;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Card client(Client client) {
        this.setClient(client);
        return this;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Card bank(Bank bank) {
        this.setBank(bank);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        return getId() != null && getId().equals(((Card) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Card{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", cardBalance=" + getCardBalance() +
            ", cardExpiredDate='" + getCardExpiredDate() + "'" +
            ", cardCreateDate='" + getCardCreateDate() + "'" +
            ", cardToken='" + getCardToken() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", cardStatus='" + getCardStatus() + "'" +
            "}";
    }
}
