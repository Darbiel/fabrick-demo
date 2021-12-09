package it.fabrick.demo.repository;

import it.fabrick.demo.entity.AccountTransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<AccountTransactionEntity, Long> {
}
