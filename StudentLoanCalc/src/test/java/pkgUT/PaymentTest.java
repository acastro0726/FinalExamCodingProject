package pkgUT;

import static org.junit.Assert.*;

import java.time.LocalDate;

import app.Helper.Payment;
import org.junit.Test;

public class PaymentTest {
	private static LocalDate ld = LocalDate.of(2019, 5, 1);

	@Test
	public void test() {
		Payment p1 = new Payment(10000.0,.1,107.46,100.0,ld);
		Payment p2 = new Payment(9875.873,.1,107.46,100.0,ld);
		//fail("Not yet implemented");
	}
	
}