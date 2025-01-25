package pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
