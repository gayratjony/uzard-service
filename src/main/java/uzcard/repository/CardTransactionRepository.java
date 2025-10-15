package uzcard.repository;

import uzcard.domain.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for the CardTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CardTransactionRepository extends JpaRepository<CardTransaction, UUID> {}
