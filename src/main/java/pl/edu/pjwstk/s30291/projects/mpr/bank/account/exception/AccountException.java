package pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception;

import java.util.UUID;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.Account;
import pl.edu.pjwstk.s30291.projects.mpr.bank.exception.BankException;

public class AccountException extends BankException {
	private UUID accountId;
	
	public AccountException(UUID accountId) {
		this.accountId = accountId;
	}
	
	public UUID getAccountId() {
		return accountId;
	}
}
