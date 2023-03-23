package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread3;

public class Thread3main {

	public static void main(String[] args) {
		MyThread3 myThread3=new MyThread3();
		myThread3.setName("MyThread3");
		myThread3.start();

	}

}
