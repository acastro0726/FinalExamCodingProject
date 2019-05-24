package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Loan Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Loan Amount: " + dLoanAmount);	
		
		/*System.out.println("Interest Rate: " + InterestRate.getText());
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		System.out.println("Interest Rate: " + dInterestRate);	
		
		System.out.println("Number of Years: " + NbrOfYears.getText());
		double dNbrOfYears = Double.parseDouble(NbrOfYears.getText());
		System.out.println("Number of Years: " + dNbrOfYears);	
		
		System.out.println("Additional Payment: " + AdditionalPayment.getText());
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println("Additional Payment: " + dAdditionalPayment);	
		*/
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
	}
}
