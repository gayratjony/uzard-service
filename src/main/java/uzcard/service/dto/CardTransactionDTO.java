package uzcard.service.dto;

import uzcard.domain.CardTransaction;
import uzcard.domain.enumeration.TransactionStatus;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link CardTransaction} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CardTransactionDTO implements Serializable {

    private UUID id;

    private Long amount;

    private TransactionStatus status;

    private Long createdDate;

    @NotNull
    private CardDTO recipient;

    @NotNull
    private CardDTO sender;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public CardDTO getRecipient() {
        return recipient;
    }

    public void setRecipient(CardDTO recipient) {
        this.recipient = recipient;
    }

    public CardDTO getSender() {
        return sender;
    }

    public void setSender(CardDTO sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CardTransactionDTO)) {
            return false;
        }

        CardTransactionDTO cardTransactionDTO = (CardTransactionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cardTransactionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CardTransactionDTO{" +
            "id='" + getId() + "'" +
            ", amount=" + getAmount() +
            ", status='" + getStatus() + "'" +
            ", createdDate=" + getCreatedDate() +
            ", recipient=" + getRecipient() +
            ", sender=" + getSender() +
            "}";
    }
}
