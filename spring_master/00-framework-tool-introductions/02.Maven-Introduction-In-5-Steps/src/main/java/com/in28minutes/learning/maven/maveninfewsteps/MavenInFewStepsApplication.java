package com.in28minutes.learning.maven.maveninfewsteps;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MavenInFewStepsApplication {

	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSortAlgorithm());
		// above steps can be removed by Application context
		ConfigurableApplicationContext applicationContext= SpringApplication.run(MavenInFewStepsApplication.class,args);
		BinarySearchImpl binarySearch=applicationContext.getBean(BinarySearchImpl.class);
		int result=binarySearch.binarySearch(new int[]{4,5,3},3);
		System.out.println(result);



		//SpringApplication.run(MavenInFewStepsApplication.class, args);
	}
}
