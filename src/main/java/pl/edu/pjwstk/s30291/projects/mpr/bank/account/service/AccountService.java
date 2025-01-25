package pl.edu.pjwstk.s30291.projects.mpr.bank.account.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.Account;
import pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception.impl.AccountNotFoundException;
import pl.edu.pjwstk.s30291.projects.mpr.bank.account.repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository accounts;
	
	public AccountService(AccountRepository accounts) {
		this.accounts = accounts;
	}
	
	public Account create(String name, String surname) {
		return create(name, surname, 0);
	}
	
	public Account create(String name, String surname, double balance) {
		return accounts.save(new Account(name, surname, balance));
	}
	
	public Account fetch(UUID id) {
		Optional<Account> account = accounts.findById(id);
		
		if(!account.isPresent()) throw new AccountNotFoundException(id);
		
		return account.get();
	}
	
	public void update(Account account) {
		if(!exists(account)) throw new AccountNotFoundException(account.getId());
		
		accounts.save(account);
	}
	
	public boolean exists(Account account) {
		return (account != null) && exists(account.getId());
	}
	
	public boolean exists(UUID id) {
		return (id != null) && accounts.existsById(id);
	}
}


