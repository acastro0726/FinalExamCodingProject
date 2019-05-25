package app.controller;

import app.StudentCalc;
import app.Helper.Loan;
import app.Helper.Payment;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private DatePicker fstPmtDate;
	
	@FXML
	private TextField addPmt;
	
	@FXML
	private Label lblTotalPayments;
	
	@FXML
	private Label lblTotalInterest;
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	
	//Initializes total interest and total payments to 0.00
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
	
	
		public Loan createLoan(double loanAmount, double interestRate, int term, double addPay,LocalDate ld) 
		{
			return new Loan(loanAmount, interestRate, term, addPay,ld);
		}
		
		
		
		public void setLabels(Loan l) 
		{
			lblTotalPayments.setText(df.format(Math.round(l.calculateTotalPayment()*100.0)/100.0));
			lblTotalInterest.setText(df.format(Math.round(l.calculateInterestPayment()*100.0)/100.0));
		}
		
		
		
		
		/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) 
	{

		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		double interestRate = Double.parseDouble(InterestRate.getText())/100.0;
		int term = Integer.parseInt(NbrOfYears.getText());
		double additionPmt = Double.parseDouble(addPmt.getText());
		LocalDate firstDate = fstPmtDate.getValue(); ;
		Loan myLoan = createLoan(dLoanAmount, interestRate, term, additionPmt, firstDate);
		setLabels(myLoan);
		
	}
	
	
}