package pl.edu.pjwstk.s30291.projects.mpr.bank.account.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
	
		service.exists(UUID.randomUUID());
	}
	
}
