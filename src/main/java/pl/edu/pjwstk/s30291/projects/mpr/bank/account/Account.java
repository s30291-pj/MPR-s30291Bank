package pl.edu.pjwstk.s30291.projects.mpr.bank.account;

import java.util.UUID;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pl.edu.pjwstk.s30291.projects.mpr.bank.account.exception.impl.BalanceNotSufficientException;

@Entity
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Nonnull private String name;
	@Nonnull private String surname;
	
	private double balance = 0;
	
	@Deprecated
	public Account() {}
	
	public Account(String name, String surname) {
		this(name, surname, 0);
	}
	
	public Account(String name, String surname, double balance) {
		this.name = name;
		this.surname = surname;
		this.balance = balance;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void removeBalance(double amount) {
		if(!hasEnough(amount)) throw new BalanceNotSufficientException(id);
		
		this.balance -= amount;
	}
	
	public void addBalance(double amount) {
		this.balance += amount;
	}
	
	public boolean hasEnough(double amount) {
		return balance >= amount;
	}
}
