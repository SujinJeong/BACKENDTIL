package com.example.springidol;

public class Encore {
	private Performer encorePerformer;

	public void setPerformer(Performer p) {
		this.encorePerformer = p;
	}

	public void execute() {
		System.out.println("<Encore Performance>");
		encorePerformer.perform();
	}
}
