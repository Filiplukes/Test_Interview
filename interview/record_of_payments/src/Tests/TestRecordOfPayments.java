package Tests;
/**
*
* @author Filip Lukeš

*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import services.RecordOfPayments;

public class TestRecordOfPayments {
	public RecordOfPayments testRecord = new RecordOfPayments();
	
	
	@Test
	public void testToUSDPositiveNumber() {
	testRecord.setSum(100);
	testRecord.setToUSD(1);
	assertEquals( 100.0, testRecord.toUSD(),1e-15);
	}

	@Test
	public void testToUSDNegativeNumber() {
	testRecord.setSum(-100);
	testRecord.setToUSD(-2);
	assertEquals( -0.0, testRecord.toUSD(),1e-15);
	}


	@Test
	public void testToUSDPositiveNegativeNumber() {
	testRecord.setSum(100);
	testRecord.setToUSD(-2.59);
	assertEquals(0.0, testRecord.toUSD(),1e-15);
	}
	
	@Test
	public void testToUSDNegativePositiveNumber() {
	testRecord.setSum(-500);
	testRecord.setToUSD(1.59);
	assertEquals(-795.0, testRecord.toUSD(),1e-15);
	}
}
