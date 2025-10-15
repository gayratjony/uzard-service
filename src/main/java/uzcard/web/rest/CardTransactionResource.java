package uzcard.web.rest;

import uzcard.domain.CardTransaction;
import uzcard.repository.CardTransactionRepository;
import uzcard.service.CardTransactionService;
import uzcard.service.dto.CardTransactionDTO;
import uzcard.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * REST controller for managing {@link CardTransaction}.
 */
@RestController
@RequestMapping("/api/card-transactions")
public class CardTransactionResource {

    private static final Logger LOG = LoggerFactory.getLogger(CardTransactionResource.class);

    private static final String ENTITY_NAME = "cardTransaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CardTransactionService cardTransactionService;

    private final CardTransactionRepository cardTransactionRepository;

    public CardTransactionResource(CardTransactionService cardTransactionService, CardTransactionRepository cardTransactionRepository) {
        this.cardTransactionService = cardTransactionService;
        this.cardTransactionRepository = cardTransactionRepository;
    }

    /**
     * {@code POST  /card-transactions} : Create a new cardTransaction.
     *
     * @param cardTransactionDTO the cardTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cardTransactionDTO, or with status {@code 400 (Bad Request)} if the cardTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<CardTransactionDTO> createCardTransaction(@Valid @RequestBody CardTransactionDTO cardTransactionDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save CardTransaction : {}", cardTransactionDTO);
        if (cardTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new cardTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        cardTransactionDTO = cardTransactionService.save(cardTransactionDTO);
        return ResponseEntity.created(new URI("/api/card-transactions/" + cardTransactionDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, cardTransactionDTO.getId().toString()))
            .body(cardTransactionDTO);
    }

    /**
     * {@code PUT  /card-transactions/:id} : Updates an existing cardTransaction.
     *
     * @param id the id of the cardTransactionDTO to save.
     * @param cardTransactionDTO the cardTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cardTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the cardTransactionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cardTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CardTransactionDTO> updateCardTransaction(
        @PathVariable(value = "id", required = false) final UUID id,
        @Valid @RequestBody CardTransactionDTO cardTransactionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update CardTransaction : {}, {}", id, cardTransactionDTO);
        if (cardTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cardTransactionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cardTransactionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        cardTransactionDTO = cardTransactionService.update(cardTransactionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cardTransactionDTO.getId().toString()))
            .body(cardTransactionDTO);
    }

    /**
     * {@code PATCH  /card-transactions/:id} : Partial updates given fields of an existing cardTransaction, field will ignore if it is null
     *
     * @param id the id of the cardTransactionDTO to save.
     * @param cardTransactionDTO the cardTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cardTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the cardTransactionDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cardTransactionDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cardTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CardTransactionDTO> partialUpdateCardTransaction(
        @PathVariable(value = "id", required = false) final UUID id,
        @NotNull @RequestBody CardTransactionDTO cardTransactionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update CardTransaction partially : {}, {}", id, cardTransactionDTO);
        if (cardTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, cardTransactionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!cardTransactionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CardTransactionDTO> result = cardTransactionService.partialUpdate(cardTransactionDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cardTransactionDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /card-transactions} : get all the cardTransactions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cardTransactions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<CardTransactionDTO>> getAllCardTransactions(
         Pageable pageable
    ) {
        LOG.debug("REST request to get a page of CardTransactions");
        Page<CardTransactionDTO> page = cardTransactionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /card-transactions/:id} : get the "id" cardTransaction.
     *
     * @param id the id of the cardTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cardTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CardTransactionDTO> getCardTransaction(@PathVariable("id") UUID id) {
        LOG.debug("REST request to get CardTransaction : {}", id);
        Optional<CardTransactionDTO> cardTransactionDTO = cardTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cardTransactionDTO);
    }

    /**
     * {@code DELETE  /card-transactions/:id} : delete the "id" cardTransaction.
     *
     * @param id the id of the cardTransactionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardTransaction(@PathVariable("id") UUID id) {
        LOG.debug("REST request to delete CardTransaction : {}", id);
        cardTransactionService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
