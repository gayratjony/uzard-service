package uzcard.service.mapper;

import uzcard.domain.Client;
import uzcard.service.dto.ClientDTO;
import uzcard.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {}
