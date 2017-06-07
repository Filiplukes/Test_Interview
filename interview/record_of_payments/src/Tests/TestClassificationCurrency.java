package Tests;
/**
*
* @author Filip Lukeš

*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import services.ClassificationCurrency;
import services.RecordOfPayments;

public class TestClassificationCurrency {

	private RecordOfPayments testPayments = new RecordOfPayments();
	private ClassificationCurrency clasiffication = new ClassificationCurrency();
	@Test
	public void testCassification2String() {

		String[] splitedInput = { "test", "asd" };
		testPayments = clasiffication.Cassification(splitedInput);
		assertEquals(null,testPayments.getName());
	}
	@Test
	public void testCassification1String() {
		String[] splitedInput = { "test" };
		testPayments = clasiffication.Cassification(splitedInput);
		assertEquals(null,testPayments.getName());
	}
	@Test
	public void testCassification3String() {
		String[] splitedInput = { "test","test2","test3" };
		testPayments = clasiffication.Cassification(splitedInput);
		assertEquals(null,testPayments.getName());
	}
	@Test
	public void testCassificationStringNumber() {
		String[] splitedInput = { "ASD","202.5",};
		testPayments = clasiffication.Cassification(splitedInput);
		assertEquals(202.5, testPayments.getSum(),1e-15);
		assertEquals("ASD", testPayments.getName());
		
	}
	@Test
	public void testCassificationNumberString() {
		String[] splitedInput = { "503554.156","PBS",};
		testPayments = clasiffication.Cassification(splitedInput);
		assertEquals(503554.156, testPayments.getSum(),1e-15);
		assertEquals("PBS", testPayments.getName());
		
	}
	
	@Test
	public void testCassificationNumberNumber() {
		String[] splitedInput = { "-503554.156","ASASaS",};
		testPayments = clasiffication.Cassification(splitedInput);
		assertEquals(-503554.156, testPayments.getSum(),1e-15);
		assertEquals("ASASAS", testPayments.getName());
		
	}
	
	
}
