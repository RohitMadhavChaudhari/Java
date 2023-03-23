package com.jspiders.multithreading.main;

import java.nio.channels.AcceptPendingException;

import com.jspiders.multithreading.resources.Account;
import com.jspiders.multithreading.resources.HusBand;
import com.jspiders.multithreading.resources.Wife;

public class AcoountMain {

	public static void main(String[] args) {
		Account account=new Account(10000);
		
		HusBand husband=new HusBand(account);
		Wife wife=new Wife(account);
		
		husband.start();
		wife.start();
		
	}

}
