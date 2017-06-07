/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Filip Lukeš

 */

public class ClassificationCurrency {
    private String currency;
    private double amount;
    private RecordOfPayments payments = new RecordOfPayments();
    // return a currency object
    public RecordOfPayments Cassification(String [] splitedInput){
    //monitors the currency name and the numeric value
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
    payments.setName(currency);
    payments.setSum(amount);
	return payments;
    
    
    }
}
