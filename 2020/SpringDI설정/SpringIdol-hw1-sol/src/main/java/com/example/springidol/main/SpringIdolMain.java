package com.example.springidol.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.springidol.TalentCompetition;
import com.example.springidol.Encore;

public class SpringIdolMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol-hw1.xml");

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();
		
		Encore encore = ctx.getBean("encore", Encore.class);
		encore.execute();
		
		ctx.close(); 
	}
}
