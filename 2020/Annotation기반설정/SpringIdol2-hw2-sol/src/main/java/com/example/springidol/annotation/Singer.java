package com.example.springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.springidol.PerformanceException;
import com.example.springidol.Performer;

@Component("chris")
public class Singer implements Performer {
	private String myName;
	private Song mySong;

	@Autowired(required=false)
	public Singer() {
	}

	@Autowired(required=false)
	public Singer(  
		@Value("Chris Kim") String name, 
		@Qualifier("bohemian") Song song) {
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
