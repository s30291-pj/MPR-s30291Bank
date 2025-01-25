package pl.edu.pjwstk.s30291.projects.mpr.bank.account.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
	
}
