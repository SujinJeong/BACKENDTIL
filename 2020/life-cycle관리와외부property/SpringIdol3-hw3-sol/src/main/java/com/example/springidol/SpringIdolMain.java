package com.example.springidol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolMain {
	public static void main(String[] args) {
		System.out.println("SpringIdolMain starts."); 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();		
		Encore encore = ctx.getBean("encore", Encore.class);
		encore.execute();

		ctx.close();
	}
}
