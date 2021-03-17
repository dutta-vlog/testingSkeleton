package bdd.cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStepDefinition {
	
	public SampleStepDefinition() {
		System.out.println("Inside Sample Step difinition Constructor");
	}

	@Given("^Executing Given statement$")
	public void executing_Given_statement() throws Throwable {
	   System.out.println("Inside Given statement");
	}

	@When("^Executing when statement$")
	public void executing_when_statement() throws Throwable {
		System.out.println("Inside When statement");
	}

	@Then("^Executing then statement not Implemented$")
	public void executing_then_statement() throws Throwable {
		System.out.println("Inside Then statement");
	}
	
	@Given("Background Given Executing")
	public void background_given_executing() {
		System.out.println("Inside Background Given statement");
		 
	}
	@When("Background When is executing")
	public void background_when_is_executing() {
		System.out.println("Inside Background When statement");
	}
	@Then("Background then is executing")
	public void background_then_is_executing() {
		System.out.println("Inside Background Then statement");
	}
	
	
	@Before
	public void beforeExecutionForAll(Scenario sc) {
		System.out.println("Inside before execution for all tag-------------------");
		  System.out.println(sc.getName());
	}
	

	@Before("@sample")
	public void beforeExecution(Scenario sc) {
		System.out.println("Inside before execution for sample tag-------------------");
		  System.out.println(sc.getName());
	}
	
}
