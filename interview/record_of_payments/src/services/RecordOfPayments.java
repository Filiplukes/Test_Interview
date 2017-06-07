package services;
/**
*
* @author Filip Lukeš

*/
// It is object currency for paytments
public class RecordOfPayments {
	private String name;
	private double sum = 0;
	private double toUSD;

	public double getToUSD() {
		return toUSD;
	}

	public void setToUSD(double toUSD) {
		if (toUSD > 0.0) {
			this.toUSD = toUSD;
		} else {
			System.err.println("It can not be a negative value.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum + this.sum;
	}
	// returns the conversion to USD
	public double toUSD() {

		return toUSD * sum;
	}

}
