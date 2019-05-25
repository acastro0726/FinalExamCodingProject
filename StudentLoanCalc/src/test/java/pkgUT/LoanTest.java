package pkgUT;

import static org.junit.Assert.*;

import java.time.LocalDate;

import app.Helper.Loan;
import app.Helper.Payment;

import org.junit.Test;

public class LoanTest {

	public static LocalDate ld = LocalDate.of(2019,5,1);
	
	@Test
	public void test() 
	{
		Loan L = new Loan(1000.0, 0.07, 1, 10.0,ld);
		for(Payment p : L.getLoanPayments()) 
		{
			System.out.println(p.getBalance());
		}
		System.out.println("Last Principle Payment: " + L.getLoanPayments().getLast().getPrinciple());
		System.out.println("Last Interest Payment: " + L.getLoanPayments().getLast().getInterest());

	}

	@Test
	public void test2() {
		//int i = 1;
		double sum = 0.0;
		Loan studentL = new Loan(80000.0, .07, 15, 100,ld);
		for(Payment p : studentL.getLoanPayments()) 
		{
			sum+=p.getInterest();
			
		}
		System.out.println("Total Interest: " + sum);
		System.out.println("Calc Total Interest: " + studentL.calculateInterestPayment());
	}
	

	@Test
	public void totalPrincipleTest() {
		Loan L = new Loan(1000.0, 0.07, 1, 10.0,ld);
		double princ = L.calculatePrinciplePayment();
		System.out.println("Total Principal Payments: " + princ);
		assertTrue(princ == 1000.0);
	}
	
	@Test
	public void totalInterestTest() {
		Loan L = new Loan(1000.0, 0.07, 1, 10.0,ld);
		double interest = L.calculateInterestPayment();
		System.out.println("Total Interest Payments: " + interest);
		assertTrue(interest == 34.54);
	}
	
}