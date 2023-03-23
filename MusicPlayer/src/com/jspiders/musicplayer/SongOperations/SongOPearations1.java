package com.jspiders.musicplayer.SongOperations;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;



public class SongOPearations1 {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static int result;
	private static Properties properties;
	private static FileReader fileReader;
	private static String query;
	private static String filePath="D:\\WEJE3\\MusicPlayer\\resources\\db_info.properties";
	
	
    static Scanner sc=new Scanner(System.in);
    public void myPlaylist()
    {
    	try {
    		fileReader=new FileReader(filePath);
    	    properties=new Properties();
    	    properties.load(fileReader);
    	    
    	    Class.forName(properties.getProperty("driverPath"));
    	    
    	    connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
    	    query = "SELECT * FROM MUSIC ";
                    
            
    	    preparedStatement=connection.prepareStatement(query);
    	    resultSet=preparedStatement.executeQuery();
    	    System.out.println("@@@@@@My PlayList@@@@@@");
    	    while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+resultSet.getString(2)+"||"
			            +resultSet.getString(3)+"||"
			            +resultSet.getString(4));
			}
    	    
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    
	public  void playallsongs()
	{
			try {
				
				fileReader=new FileReader(filePath);
			    properties=new Properties();
			    properties.load(fileReader);
			    
			    Class.forName(properties.getProperty("driverPath"));
			    
			    connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			    query = "SELECT * FROM MUSIC "
		                + "ORDER BY RAND() "
		                + "LIMIT 5";
		        
			    preparedStatement=connection.prepareStatement(query);
			    resultSet=preparedStatement.executeQuery();
			    
			    while (resultSet.next()) {
					System.out.println(resultSet.getString(2));
				}
			    System.out.println("All Songs Are Playing..");
					    
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	

	public  void choosesong()
	{
		
		try {
			
			Scanner scanner=new Scanner(System.in);
			fileReader=new FileReader(filePath);
		    properties=new Properties();
		    properties.load(fileReader);
		    
		    Class.forName(properties.getProperty("driverPath"));
		    
		    connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
		    query = "select * from music ";
		    
		    preparedStatement=connection.prepareStatement(query);
		  
		    resultSet=preparedStatement.executeQuery();
		   
		    
		    while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+resultSet.getString(2)+"||"
			            +resultSet.getString(3)+"||"
			            +resultSet.getString(4));
			}
		    
		
		    
		    connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
		    query = "select * from music "
					+ "where SongNumber = ?";;
		    
		    preparedStatement=connection.prepareStatement(query);
		    System.out.println("Enter the song number :");
		    preparedStatement.setInt(1,scanner.nextInt());
		    resultSet=preparedStatement.executeQuery();
		   
		    
		    while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+resultSet.getString(2)+"||"
			            +resultSet.getString(3)+"||"
			            +resultSet.getString(4));
			}
		    System.out.println("Your Selectd song Is Playing..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void randomSongs() {
	    try {
	        fileReader = new FileReader(filePath);
	        properties = new Properties();
	        properties.load(fileReader);
	        
	        Class.forName(properties.getProperty("driverPath"));
	        
	        connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
	        query = "SELECT * FROM MUSIC "
	                + "ORDER BY RAND() "
	                + "LIMIT 1";
	        
	        preparedStatement = connection.prepareStatement(query);
	        resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            System.out.println("Playing song: " + resultSet.getString(2));
	            // code to play the song goes here
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void addSongs()
	{
		try {
			

			fileReader=new FileReader(filePath);
			properties=new Properties();
			properties.load(fileReader);

			
			Class.forName(properties.getProperty("driverPath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			query="insert into music values "+"(?,?,?,?)";
			
			preparedStatement=connection.prepareStatement(query);
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("Enter the SongNumber");
			preparedStatement.setInt(1,scanner.nextInt());
			scanner.nextLine();
			System.out.println("Enter the SongName");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter the SingerName");
			preparedStatement.setString(3,scanner.nextLine());
		    System.out.println("Enter the SongDuration");
			preparedStatement.setString(4, scanner.nextLine());
			
		
			result=preparedStatement.executeUpdate();
			System.out.println("Song Added In Your PlayList");
			
		} catch (Exception e) {
			System.out.println("You Cant Add One Song More Than Ones:");
			e.printStackTrace();
		}

	}

	public void removeSongs()
	{
		try {
			Scanner scanner=new Scanner(System.in);
			
			fileReader=new FileReader(filePath);
			properties=new  Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			query = "delete from music "
					+ "where songNumber= ?";
			
			preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter the SongNumber to remove song");
			preparedStatement.setInt(1,scanner.nextInt());
			
			result = preparedStatement.executeUpdate();
			if(result!=0)
			{
				System.out.println("Song Removed.");
			}
			else
			{
				System.out.println("Does not exists");

			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	public void editsong()
	{
		try {
		
			fileReader=new FileReader(filePath);
		    properties=new Properties();
		    properties.load(fileReader);
		    
		    Class.forName(properties.getProperty("driverPath"));
		    
		    connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
		    query = "select * from music ";
		    
		    preparedStatement=connection.prepareStatement(query);
		    resultSet=preparedStatement.executeQuery();
		    while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||"
						+resultSet.getString(2)+"||"
			            +resultSet.getString(3)+"||"
			            +resultSet.getString(4));
			}
		   System.out.println();
			       
		   System.out.println("Enter want to you edit\n"
		   		+ "1]SongName\n"
		   		+ "2]SingerName");
		   
		    Scanner scanner=new Scanner(System.in);
		    int choice=scanner.nextInt();
		    
		    
		       switch (choice) {
			case 1: query = "update music "
		    		+ "set SongName=? "
		    		+ "where SongNumber=?";
		    
		    preparedStatement=connection.prepareStatement(query);
		    
		 
		    System.out.println("Enter SongNumber that you update the song");
		    preparedStatement.setInt(2,scanner.nextInt());
		    scanner.nextLine();
		    System.out.println("Enter new song name");
		    preparedStatement.setString(1, scanner.nextLine());
		    
		    result=preparedStatement.executeUpdate();
		    
		    System.out.println("Song Edited");
				
				break;
         
				
			case 2: query = "update music "
		    		+ "set SingerName=? "
		    		+ "where SongNumber=?";
		    
		    preparedStatement=connection.prepareStatement(query);
		    
		 
		    System.out.println("Enter SongNumber that you update the song");
		    preparedStatement.setInt(2,scanner.nextInt());
		    scanner.nextLine();
		    System.out.println("Enter new song name");
		    preparedStatement.setString(1, scanner.nextLine());
		    
		    result=preparedStatement.executeUpdate();
		    
		    System.out.println("Song Edited");
				
				break;
				
			default:System.out.println("Invalid choice");
				break;
			}
		    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
}
