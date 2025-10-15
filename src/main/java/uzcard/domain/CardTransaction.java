package uzcard.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uzcard.domain.enumeration.TransactionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * A CardTransaction.
 */
@Entity
@Table(name = "card_transaction")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CardTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    @Column(name = "created_date")
    private Long createdDate;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "client", "bank" }, allowSetters = true)
    private Card recipient;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "client", "bank" }, allowSetters = true)
    private Card sender;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public UUID getId() {
        return this.id;
    }

    public CardTransaction id(UUID id) {
        this.setId(id);
        return this;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getAmount() {
        return this.amount;
    }

    public CardTransaction amount(Long amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public CardTransaction status(TransactionStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Long getCreatedDate() {
        return this.createdDate;
    }

    public CardTransaction createdDate(Long createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Card getRecipient() {
        return this.recipient;
    }

    public void setRecipient(Card card) {
        this.recipient = card;
    }

    public CardTransaction recipient(Card card) {
        this.setRecipient(card);
        return this;
    }

    public Card getSender() {
        return this.sender;
    }

    public void setSender(Card card) {
        this.sender = card;
    }

    public CardTransaction sender(Card card) {
        this.setSender(card);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CardTransaction)) {
            return false;
        }
        return getId() != null && getId().equals(((CardTransaction) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CardTransaction{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", status='" + getStatus() + "'" +
            ", createdDate=" + getCreatedDate() +
            "}";
    }
}
