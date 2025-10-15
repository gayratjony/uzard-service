package uzcard.service.mapper;

import uzcard.domain.Bank;
import uzcard.service.dto.BankDTO;
import uzcard.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Bank} and its DTO {@link BankDTO}.
 */
@Mapper(componentModel = "spring")
public interface BankMapper extends EntityMapper<BankDTO, Bank> {}
