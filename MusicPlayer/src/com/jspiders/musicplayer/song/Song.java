package com.jspiders.musicplayer.song;

public class Song {
  
	private int number;
	private String name;
	private String singer;
	private double duration;

	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number) 
	{
		this.number = number;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	public String getSinger() 
	{
		return singer;
	}
	public void setSinger(String singer) 
	{
		this.singer = singer;
	}
	
	public double getduration() 
	{
		return duration;
	}
	public void setduration(double Duration)
	{
		duration = Duration;
	}
	
	 public Song(int nu,String n,String s,double d) {
		this.number=nu;
		this.name=n;
		this.singer=s;
		this.duration=d;
		
	}

	
	@Override
	public String toString() {
		return "Song number="
	           + number + ",song name=" + name + 
	           ", singer of the song=" + singer 
				+ ", song duration is=" + duration ;
	}
	public Song(){

	}
	
	
}

