package uzcard.service.mapper;

import uzcard.domain.Bank;
import uzcard.domain.Card;
import uzcard.domain.Client;
import uzcard.service.dto.BankDTO;
import uzcard.service.dto.CardDTO;
import uzcard.service.dto.ClientDTO;
import uzcard.service.mapper.EntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Objects;
import java.util.UUID;

/**
 * Mapper for the entity {@link Card} and its DTO {@link CardDTO}.
 */
@Mapper(componentModel = "spring")
public interface CardMapper extends EntityMapper<CardDTO, Card> {
    @Mapping(target = "client", source = "client", qualifiedByName = "clientId")
    @Mapping(target = "bank", source = "bank", qualifiedByName = "bankId")
    CardDTO toDto(Card s);

    @Named("clientId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClientDTO toDtoClientId(Client client);

    @Named("bankId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BankDTO toDtoBankId(Bank bank);

    default String map(UUID value) {
        return Objects.toString(value, null);
    }
}
