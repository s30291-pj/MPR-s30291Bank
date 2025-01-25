package pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<UUID, Transaction> {

}
