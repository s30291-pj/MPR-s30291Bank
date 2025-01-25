package pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import pl.edu.pjwstk.s30291.projects.mpr.bank.account.service.AccountService;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.Transaction;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.exception.impl.TransactionAmountIncorrectException;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.exception.impl.TransactionNotFoundException;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.exception.impl.TransactionReceiverNotFoundException;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.exception.impl.TransactionSenderNotFoundException;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.repository.TransactionRepository;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.type.TransactionType;

@Service
public class TransactionService {
	private TransactionRepository transactions;
	private AccountService accounts;
	
	private UUID bankAccountId;
	
	public TransactionService(TransactionRepository transactions, AccountService accounts) {
		this.transactions = transactions;
		this.accounts = accounts;
		
		this.bankAccountId = accounts.create("PJATKBank", "SA", 99999999).getId();
	}
	
	public Transaction deposit(UUID account, double amount) {
		return create(TransactionType.DEPOSIT, bankAccountId, account, amount);
	}
	
	public Transaction withdraw(UUID account, double amount) {
		return create(TransactionType.WITHDRAWAL, account, bankAccountId, amount);
	}
	
	public Transaction transfer(UUID sender, UUID receiver, double amount) {
		return create(TransactionType.WITHDRAWAL, sender, receiver, amount);
	}
	
	private Transaction create(TransactionType type, UUID sender, UUID receiver, double amount) {	
		process();
		
		return transactions.save(new Transaction(type, sender, receiver, amount));
	}
	
	private void process(Transaction transaction) {
		UUID sender = transaction.getSender();
		UUID recipent = transaction.getRecipent();
		double amount = transaction.getAmount();
		
		if(amount < 0) transaction.reject("Transaction amount incorrect!");
		else if(!accounts.exists(sender)) transaction.reject("Sender account not found!");
		else if(!accounts.exists(recipent)) transaction.reject("Recipent account not found!");
		else transaction.accept();
		
		transactions.save(transaction);
	}
	
	public Transaction fetch(UUID id) {
		Optional<Transaction> transaction = transactions.findById(id);

		if(!transaction.isPresent()) throw new TransactionNotFoundException();
		
		return transaction.get();
	}
}
