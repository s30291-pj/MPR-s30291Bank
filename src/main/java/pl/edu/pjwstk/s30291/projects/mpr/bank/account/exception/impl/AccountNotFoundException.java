package pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception.impl;

import java.util.UUID;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception.AccountException;

public class AccountNotFoundException extends AccountException {

	public AccountNotFoundException(UUID accountId) {
		super(accountId);
	}

}
