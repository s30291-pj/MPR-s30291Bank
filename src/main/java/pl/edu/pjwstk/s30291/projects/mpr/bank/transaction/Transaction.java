package pl.edu.pjwstk.s30291.projects.mpr.bank.transaction;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.exception.TransactionException;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.status.TransactionStatus;
import pl.edu.pjwstk.s30291.projects.mpr.bank.transaction.type.TransactionType;

@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Nonnull private UUID recipent;
	@Nonnull private UUID sender;
	@Nonnull private TransactionType type;
	
	private TransactionStatus status = TransactionStatus.PENDING;
	
	private double amount = 0;
	
	private LocalDate timestamp = LocalDate.now();
	
	private String message = "Transaction is pending!";
	
	@Deprecated
	public Transaction() {}
	
	public Transaction(TransactionType type, UUID sender, UUID recipent, double amount) {
		this.sender = sender;
		this.recipent = recipent;
		this.amount = amount;
	}
	
	public void reject(String message) {
		this.status = TransactionStatus.REJECTED;
		this.message = message;
	}
	
	public void accept() {
		this.status = TransactionStatus.ACCEPTED;
		this.message = "Transaction was procced!";
	}
	
	public UUID getId() {
		return id;
	}
	
	public UUID getRecipent() {
		return recipent;
	}
	
	public UUID getSender() {
		return sender;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public LocalDate getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}

}
