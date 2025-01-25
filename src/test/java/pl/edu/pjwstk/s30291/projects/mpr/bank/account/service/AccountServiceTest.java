package pl.edu.pjwstk.s30291.projects.mpr.bank.account.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.Account;
import pl.edu.pjwstk.s30291.projects.mpr.bank.account.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
	@InjectMocks
	private AccountService service;
	
	@Mock
	private AccountRepository accounts;
	
	@Test
	public void testExists() {
		when(accounts.existsById(any())).thenReturn(true);
	
		assertTrue(service.exists(UUID.randomUUID()));
	}
	
	@Test
	public void testNotExists() {
		when(accounts.existsById(any())).thenReturn(false);
	
		assertFalse(service.exists(UUID.randomUUID()));
	}
	
}
