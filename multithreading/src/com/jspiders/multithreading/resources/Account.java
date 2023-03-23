package com.jspiders.multithreading.resources;

public class Account {

	double accountbalance;

	public Account(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	public double checkBalance()
	{
		return this.accountbalance; 
	}
	
	public void deposite(double amount)
	{
		System.out.println("Deposting "+amount+" in account");
	    accountbalance+=amount;
	    System.out.println("Current balance "+checkBalance());
	}
	
	public void withdraw(double amount)
	{

		System.out.println("Withdrawing "+amount+" in account");
	    accountbalance-=amount;
	    System.out.println("Current balance  "+checkBalance());
	}
	
	
}
