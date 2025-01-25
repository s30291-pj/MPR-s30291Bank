package pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception.impl;

import java.util.UUID;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception.AccountException;

public class BalanceNotSufficientException extends AccountException {
	
	public BalanceNotSufficientException(UUID accountId) {
		super(accountId);
	}
}
