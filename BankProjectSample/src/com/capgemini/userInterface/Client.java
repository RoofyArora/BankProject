package com.capgemini.userInterface;

import java.util.Scanner;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.service.Bank;
import com.capgemini.service.ICICIBank;

public class Client {
	
	private static Scanner sc = new Scanner(System.in);
	private static Bank bank = new ICICIBank();
	
	public static void main(String[] args) throws InsufficientBalanceException, InsufficientOpeningBalanceException, InvalidAccountNumberException {
		 
			Menu();
	}
	
	private static void Menu() throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalanceException
	{
		while(true)
		{
			System.out.println("1. Create Account");
			System.out.println("2. Withdraw Amount");
			System.out.println("3. Deposit Amount");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice: ");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				createAccount();
				break;
			case 2:
				withdrawAmount();
				break;
			case 3:
				depositAmount();
				break;
			case 4:
				fundTransfer();
				break;
			case 65:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
						
		}
	}


		private static void createAccount() throws InvalidAccountNumberException, InsufficientBalanceException
		{
			
			if(true)
			{
				try {
					System.out.println("Enter your account number: ");
					int accno = sc.nextInt();
					System.out.println("Enter amount to create account");
					int amt = sc.nextInt();
					if(amt<500)
					{
						throw new InsufficientOpeningBalanceException();
					}
					else
					{
						System.out.println(bank.createAccount(accno,amt));
					}
				}
				catch(InsufficientOpeningBalanceException obe)
				{
					System.out.println("Minimum rs. 500 opening balance is required");
				}
			}

		}
		
		private static void withdrawAmount()
		{
			try
			{
				System.out.println("Enter account number:");
				int accno=sc.nextInt();
				System.out.println("Enter withdrawal amount: ");
				int withdrawamt=sc.nextInt();
				System.out.println(bank.withdrawAmount(accno, withdrawamt));
			}catch(InvalidAccountNumberException ae)
			{
				System.out.println("Invalid account number");
			}catch(InsufficientBalanceException e)
			{
				System.out.println("Insufficient Balance");
			}
		}
		private static void depositAmount()
		{
			try
			{
				System.out.println("Enter account number:");
				int accno=sc.nextInt();
				System.out.println("Enter amount to deposit : ");
				int depositamt=sc.nextInt();
				System.out.println(bank.depositAmount(accno, depositamt));
			}catch(InvalidAccountNumberException ae)
			{
				System.out.println("Invalid account number");
			}catch(InsufficientBalanceException e)
			{
				System.out.println("Insufficient Balance");
			}
			
		}
		
		private static void fundTransfer()
		{
			try
			{
				System.out.println("Enter account number who wants to transfer money from");
				int acc1=sc.nextInt();
				System.out.println("Enter account number who will receive money: ");
				int acc2=sc.nextInt();
				System.out.println("Enter amount to transfer:");
				int transferamt=sc.nextInt();
				int[] bal=bank.fundTransfer(acc1, acc2, transferamt);
				System.out.println("Sender Balance ="+bal[0]);
				System.out.println("Receiver Balance ="+bal[1]);
				
			}catch(InvalidAccountNumberException ae)
			{
			System.out.println("Invalid account number");
			}catch(InsufficientBalanceException e)
			{
				System.out.println("Insufficient balance");
			}
	}	}