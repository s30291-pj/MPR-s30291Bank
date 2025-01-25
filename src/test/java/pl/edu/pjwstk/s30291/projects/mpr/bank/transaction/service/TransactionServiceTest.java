package pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.service.AccountService;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@InjectMocks
	private TransactionService service;
	
	@Mock
	private TransactionRepository transactions;
	
	@Mock
	private AccountService accounts;
	
}
