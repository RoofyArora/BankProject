package com.capgemini.service;

import java.util.LinkedList;

import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public interface Bank
{
	String createAccount(int accountNumber, int amount) throws InsufficientOpeningBalanceException, InvalidAccountNumberException; 
	int withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int[] fundTransfer(int senderAccount, int receiverAccount, int transferAmount) throws InvalidAccountNumberException, InsufficientBalanceException;
    

	
	
}
