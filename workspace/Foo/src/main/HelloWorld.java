package main;

import java.time.LocalDateTime;

import impl.JsonNameProcessor;
import impl.SuperMan;

public class HelloWorld {
	 public static void main(String args[]) throws IllegalAccessException {
		 SuperMan sup = new SuperMan();
		 sup.setName("Sip do");
		 sup.setDateOfBirth(LocalDateTime.now());
		 sup.setAge(69);
		 System.out.println(JsonNameProcessor.toJson(sup));
	 }
}
