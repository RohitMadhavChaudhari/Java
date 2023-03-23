package com.jspiders.multithreading.main;

public class task2 {

	public static void main(String[] args) {

		int a[]= {1,4,8,16,18};
		int b[]= {3,6,10,18,20};
		int c[]=new int[5];
		int d[]=new int[5];
		
		for(int i=1;i<5;i++)
		{
			for(int j=i-1;j<5;j++)
			{
				if(a[i]==b[j]) 
				{
					
				}
				else {
					c[j]=b[j];
					d[j]=a[i];
					
				} 
			}
		}
		
		
		
	}

}
