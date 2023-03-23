package com.jspiders.multithreading.resources;

public class HusBand extends Thread {

	Account account;

	public HusBand(Account account) {
		super();
		this.account = account;
	}
	
	public void run()
	{
		account.deposite(1000);
		account.withdraw(500);
	}
}
