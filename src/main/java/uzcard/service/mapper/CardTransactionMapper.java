package uzcard.service.mapper;

import uzcard.domain.Card;
import uzcard.domain.CardTransaction;
import uzcard.service.dto.CardDTO;
import uzcard.service.dto.CardTransactionDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Objects;
import java.util.UUID;

/**
 * Mapper for the entity {@link CardTransaction} and its DTO {@link CardTransactionDTO}.
 */
@Mapper(componentModel = "spring")
public interface CardTransactionMapper extends EntityMapper<CardTransactionDTO, CardTransaction> {
    @Mapping(target = "recipient", source = "recipient", qualifiedByName = "cardId")
    @Mapping(target = "sender", source = "sender", qualifiedByName = "cardId")
    CardTransactionDTO toDto(CardTransaction s);

    @Named("cardId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CardDTO toDtoCardId(Card card);

    default String map(UUID value) {
        return Objects.toString(value, null);
    }
}
