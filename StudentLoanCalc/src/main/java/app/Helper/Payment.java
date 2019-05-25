package app.Helper;

import java.time.LocalDate;

public class Payment {
	
	private double principle;
	private double interest;
	
	private static int pmtNbr= 0;
	private int myPmtNbr;
	private double loanBalance;
	private double interestRate;
	private double monthlyPay;
	private double extraPayment;
	private LocalDate pmtDate;
	
	public void month() 
	{
		if(loanBalance>monthlyPay+extraPayment) 
		{
			interest = interestRate/12*loanBalance;
			principle = (monthlyPay-interest+extraPayment);
			loanBalance = Math.round((loanBalance - principle)*100.0)/100.0;
		}
		else 
		{
			monthlyPay = loanBalance;
			extraPayment = 0;
			principle = loanBalance;
			interest = interestRate/12*loanBalance;
			loanBalance = 0;
		}
		
		
	}
	
	public Payment(double loanBalance, double interestRate, double monthlyPmt, double extra, LocalDate ld) 
	{
		
		this.loanBalance = loanBalance;
		this.interestRate = interestRate;
		monthlyPay = monthlyPmt;
		extraPayment = extra;
		month();
		pmtDate = ld;
		pmtNbr++;
		myPmtNbr = pmtNbr;
		
	}
	

	public double getExtraPayment() 
	{
		return extraPayment;
	}
	
	public double getInterest() 
	{
		return Math.round(interest*100.0)/100.0;
	}
	
	public double getPrinciple() 
	{
		return Math.round(principle*100.0)/100.0;
	}



	public double getBalance() 
	{
		return loanBalance;
	}
	
	public int getMyPmtNbr() 
	{
		return myPmtNbr;
	}
	
	public LocalDate getPmtDate() 
	{
		return pmtDate;
	}
	
	public double getMonthlyPayment() 
	{
		return monthlyPay;
	}
	
	public void setPmtNbr(int i) 
	{
		pmtNbr = i;
	}
	

}