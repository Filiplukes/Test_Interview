Payment Tracker

Run the program using a file start_record.bat

Introduction
Program that keeps a record of payments. Created for a job interview.

Code Samples
assumption In the class RunProgram: 
if (currency.getSum() != 0) 
{ if (currency.getToUSD() != 0) 
{ System.out.format(currency.getName() + " " + "%.2f", currency.getSum() + " " + "%.2f", currency.toUSD()); }
 else { System.out.format(currency.getName() + " " + "%.2f", currency.getSum()); }

For currency listing, when the amount 0 does not print the currency.

if (toUSD[0].toUpperCase().equals("USD")) {
			System.err.println("USD to USD do not count!");
			control = true;
		}
The program does not count USD to USD, because its 1:1.

try {
sum = Double.parseDouble(toUSD[1]);
for (RecordOfPayments currency : listCurrency) {
if (currency.getName().equals(toUSD[0].toUpperCase())) {
	currency.setToUSD(sum);
control = true;
	break;
	}
		}
if (control = false) {
System.err.println("Wrong name currency!");
	}
	} catch (Exception e) {
System.err.println("Badly entered value!");
		}
The program monitors the currency name and the numeric value for the USD conversion.
   	
    if(splitedInput.length == 2){
    	try {
    		amount=Double.parseDouble(splitedInput[0]);
            currency= splitedInput[1].toUpperCase();		
		} catch (NumberFormatException e) {
			try {
				amount=Double.parseDouble(splitedInput[1]);
		        currency= splitedInput[0].toUpperCase();
			} catch (NumberFormatException e2) {
				System.err.println("Badly entered value!");
			}		
		}
        
    }else{
        System.err.println("Badly entered currency!");
    }

The program monitors the currency name and the numeric value.