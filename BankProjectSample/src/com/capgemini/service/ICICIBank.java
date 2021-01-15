package com.capgemini.service;

import java.util.LinkedList;

import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public class ICICIBank implements Bank {
	
	private LinkedList<Account> accounts = new LinkedList<>();
	
	public String createAccount(int accountNumber, int amount)
	{
		Account account = new Account(accountNumber, amount);
		accounts.add(account);
		return "account created successfully";
	}
	
	
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException
	{
		for(Account account:accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			
			}
		}
		throw new InvalidAccountNumberException();
		
		
	}
	
	
	public int withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account = searchAccount(accountNumber);
		if((account.getAmount()-amount>=500))
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufficientBalanceException();
	}
	
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account = searchAccount(accountNumber);
				account.setAmount(account.getAmount()+amount);
				return account.getAmount();
		
	}
	
	public int[] fundTransfer(int toAccount, int fromAccount, int transferAmount) throws InsufficientBalanceException, InvalidAccountNumberException
	{
		Account to=searchAccount(toAccount);
		Account from=searchAccount(fromAccount);
		
		if(to.getAmount()>=transferAmount)
		{
			//to.setAmount(to.getAmount()-transferAmount);
			//from.setAmount(from.getAmount()+transferAmount);
			
			int[] showBal = {to.getAmount()-transferAmount, from.getAmount()+transferAmount};
			
			
			return showBal;
		}
		
		throw new InsufficientBalanceException();
	}

}