/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import services.ClassificationCurrency;
import services.RecordOfPayments;

/**
 * 
 * @author Filip Lukeš
 */

public class RunProgram {
	private String inputCurrency;
	private String welcome = "Write 'quit' to turnoff the program, 'F'('f') to retrieve data from file,"
			+ "'T'('t') to setting the rate to the dollar and you can write the currency and value here.";
	private RecordOfPayments payments;
	private ArrayList<RecordOfPayments> listCurrency = new ArrayList<>();

	// running the program
	public void runProgram() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				for (RecordOfPayments currency : listCurrency) {
					// for currency listing, when the amount 0 does not print
					// the currency
					if (currency.getSum() != 0) {
						if (currency.getToUSD() != 0) {
							System.out.format(currency.getName() + " " + "%.2f", currency.getSum());
							System.out.format(" (USD %.2f)\n",currency.toUSD());
						} else {
							System.out.format(currency.getName() + " " + "%.2f\n", currency.getSum());
							
						}
					}
				}
			}
		};
		// calls a statement of payments every minute
		timer.schedule(timerTask, 6000, 6000);
		Scanner scan = new Scanner(System.in);
		// action selection
		while (true) {
			System.out.println(welcome);
			inputCurrency = scan.nextLine();
			if (inputCurrency.equals("quit")) {
				break;
			} else if (inputCurrency.equals("F") || inputCurrency.equals("f")) {
				inputCurrency = scan.nextLine();
				try (BufferedReader br = new BufferedReader(new FileReader(inputCurrency))) {
					String input;
					while ((input = br.readLine()) != null) {
						inputToArray(input.split(" "));
					}
				} catch (Exception e) {
					System.err.println("Error reading from file. You are back in the main.");
				}

			} else if (inputCurrency.equals("T") || inputCurrency.equals("t")) {
				String inputToUSD;
				do {
					System.out.println(
							"Enter the name of the currency and the value separated" + " by a space or 'b' for back");
					inputToUSD = scan.nextLine();
					if (inputToUSD.equals("b")) {
						break;
					}
				} while (stingCourtDolar(inputToUSD.split(" ")) == true);
			} else {
				inputToArray(inputCurrency.split(" "));
			}
		}

		scan.close();
		timer.cancel();
	}

	// adds a new currency to the list
	public void inputToArray(String[] splitedInput) {
		ClassificationCurrency clasiffication = new ClassificationCurrency();
		payments = clasiffication.Cassification(splitedInput);
		if ((payments.getName() != null) && (payments.getName().length() == 3)) {
			int position = -1;
			boolean control = false;
			for (RecordOfPayments currency : listCurrency) {
				position++;
				if (currency.getName().equals(payments.getName())) {
					control = true;
					break;
				}
			}
			if (control == true) {
				listCurrency.get(position).setSum((payments.getSum()));
			} else {
				listCurrency.add(payments);
			}
		}
	}

	public boolean stingCourtDolar(String toUSD[]) {
		double sum;
		boolean control = false;
		// does not count USD to USD, because its 1:1
		if (toUSD[0].toUpperCase().equals("USD")) {
			System.err.println("USD to USD do not count!");
			control = true;
		} else {
			try {
				sum = Double.parseDouble(toUSD[1]);
				for (RecordOfPayments currency : listCurrency) {
					if (currency.getName().equals(toUSD[0].toUpperCase())) {
						currency.setToUSD(sum);
						control = true;
						break;
					}

				}
				// monitors the currency name and the numeric value for the USD
				// conversion
				if (control = false) {
					System.err.println("Wrong name currency!");
				}
			} catch (Exception e) {
				System.err.println("Badly entered value!");
			}
		}
		return control;

	}

}
