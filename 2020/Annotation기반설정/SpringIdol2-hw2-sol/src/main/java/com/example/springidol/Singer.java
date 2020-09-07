package com.example.springidol;

public class Singer implements Performer {
	private String myName;
	private Song mySong;

	public Singer() {
	}

	public Singer(String name, Song song) {
		this.myName = name;
		this.mySong = song;
	}

	public Song getSong() {
		return mySong;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println(myName + " is singing a song \"" + mySong.getTitle() + "\" by " + mySong.getArtist());
	}
}
