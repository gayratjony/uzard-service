package uzcard.service;

import uzcard.domain.CardTransaction;
import uzcard.repository.CardTransactionRepository;
import uzcard.service.dto.CardTransactionDTO;
import uzcard.service.mapper.CardTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * Service Implementation for managing {@link CardTransaction}.
 */
@Service
@Transactional
public class CardTransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(CardTransactionService.class);

    private final CardTransactionRepository cardTransactionRepository;

    private final CardTransactionMapper cardTransactionMapper;

    public CardTransactionService(CardTransactionRepository cardTransactionRepository, CardTransactionMapper cardTransactionMapper) {
        this.cardTransactionRepository = cardTransactionRepository;
        this.cardTransactionMapper = cardTransactionMapper;
    }

    /**
     * Save a cardTransaction.
     *
     * @param cardTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    public CardTransactionDTO save(CardTransactionDTO cardTransactionDTO) {
        LOG.debug("Request to save CardTransaction : {}", cardTransactionDTO);
        CardTransaction cardTransaction = cardTransactionMapper.toEntity(cardTransactionDTO);
        cardTransaction = cardTransactionRepository.save(cardTransaction);
        return cardTransactionMapper.toDto(cardTransaction);
    }

    /**
     * Update a cardTransaction.
     *
     * @param cardTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    public CardTransactionDTO update(CardTransactionDTO cardTransactionDTO) {
        LOG.debug("Request to update CardTransaction : {}", cardTransactionDTO);
        CardTransaction cardTransaction = cardTransactionMapper.toEntity(cardTransactionDTO);
        cardTransaction = cardTransactionRepository.save(cardTransaction);
        return cardTransactionMapper.toDto(cardTransaction);
    }

    /**
     * Partially update a cardTransaction.
     *
     * @param cardTransactionDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CardTransactionDTO> partialUpdate(CardTransactionDTO cardTransactionDTO) {
        LOG.debug("Request to partially update CardTransaction : {}", cardTransactionDTO);

        return cardTransactionRepository
            .findById(cardTransactionDTO.getId())
            .map(existingCardTransaction -> {
                cardTransactionMapper.partialUpdate(existingCardTransaction, cardTransactionDTO);

                return existingCardTransaction;
            })
            .map(cardTransactionRepository::save)
            .map(cardTransactionMapper::toDto);
    }

    /**
     * Get all the cardTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CardTransactionDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all CardTransactions");
        return cardTransactionRepository.findAll(pageable).map(cardTransactionMapper::toDto);
    }

    /**
     * Get one cardTransaction by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CardTransactionDTO> findOne(UUID id) {
        LOG.debug("Request to get CardTransaction : {}", id);
        return cardTransactionRepository.findById(id).map(cardTransactionMapper::toDto);
    }

    /**
     * Delete the cardTransaction by id.
     *
     * @param id the id of the entity.
     */
    public void delete(UUID id) {
        LOG.debug("Request to delete CardTransaction : {}", id);
        cardTransactionRepository.deleteById(id);
    }
}
