import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForeignExchangeTrading {
	
	private static double rate = 66.00;
	
	private static List<Trade> trades = new ArrayList<>();
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("Book Trade - 1");
			System.out.println("Print Trades - 2");
			System.out.println("Exit - 3");
			System.out.println("Enter your choice : ");
			char option = sc.next().charAt(0);
			
			switch(option) {
			
			case '1':
				bookTrade();
				break;
			case '2':
				printTrade();
				break;
			case '3':
				exit();
				break;
			default:
				System.out.println("Invalid Option. Please select another option");
			}
			
		}
	}
	// Method to book trade
	private static void bookTrade() {
		
		System.out.println("Enter Customer Name ");
		sc.nextLine();
		String customerName = sc.nextLine();
		while(!checkcustomerName(customerName))
        {
        	System.out.println("Invalid Name!!...Enter valid name again Name");
        	customerName = sc.nextLine();
        }
		
		
		System.out.println("Enter Currency Pair ");
		String currencyPair = sc.nextLine().toUpperCase();
		while(!checkcurrencyPair(currencyPair)) {
			
			System.out.println("Invalid Currency Pair. Only USDINR is supported. Enter Again!!!");
			currencyPair = sc.nextLine().toUpperCase();
		}
	
		
		System.out.println("Enter amount to transfer ");
		String amountInt = sc.nextLine();
		 while(amountInt != null)
	        {
	        	if((amountInt.trim()).matches("[0-9]+"))
	        		break;
	        	else
	        	{
	        		System.out.println("Amount should be number ");
	        		amountInt = sc.nextLine();
	        	}
	        }
	    double amount = Double.parseDouble(amountInt);
		while(!checkAmount(amount)) {
			System.out.println("Invalid!!!.. Amount should be greater than zero.");
			amount = sc.nextDouble();
		}
		
		double newamount = (amount*rate);
		
		System.out.println("Do you want to get Rate (yes/No) ");
		String getRate = sc.nextLine();
		
		if(getRate.equalsIgnoreCase("Yes") || (getRate.equalsIgnoreCase("Y"))) {
			
			System.out.println("You are transferring INR "+newamount+" to "+customerName+" (Assuming that rate was "+rate+")");
		}
		else {
			System.out.println("You are transferring`INR "+newamount+" to "+customerName);
		}
		
		System.out.println("Book/Cancel this trade?");
		String decision = sc.nextLine();
		
		if(decision.equalsIgnoreCase("Book")) {
			
			 trades.add(new Trade(currencyPair, customerName, amount, rate));
			 
	            System.out.println("Trade for " + currencyPair + " has been booked with rate " + rate + ", The amount of Rs " + newamount +
	            		" will be transferred in 2 working days to " + customerName + ".");
		}
		else if(decision.equalsIgnoreCase("Cancel")) {
			System.out.println("Trade is Canceled. ");
		}
		else {
			System.out.println("Invalid Decision...Try Again!!");
		}
		
	}
	//check for customer name
	public static boolean checkcustomerName(String customerName) {
		
		if(customerName == null) {
			return false;	
		}
		
		for(char c : customerName.toCharArray()){
			if(!Character.isLetter(c) && c != ' '){
				return false;
			}
		}
		return true;
		
	}
	//check for currency pair
	public static boolean checkcurrencyPair(String currencyPair) {
			
			if(!currencyPair.equals("USDINR")) {
				return false;
				
			}else {
				return true;
			}
		}
	//check for correct amount
	public static boolean checkAmount(double amount) {
		
		if(amount<0){
			return false;
		}
		else if(amount==0){
			return false;	
		}
		else{
			return true;
		}
		
	}
	// Method to print trade
	private static void printTrade() {
		
		System.out.println("TradeNo CurrencyPair CustomerName Amount Rate");
        for (Trade trade : trades) { // for each loop
            System.out.println(trade);
        }
	}
	// Method to close 
	private static void exit() {
		
		 System.out.print("Do you really want to exit (y/n): ");
	        String confirmation = sc.next();
	        if (confirmation.equalsIgnoreCase("Y")) {
	            System.out.println("Bye - have a good day");
	            System.exit(0);
	        }
	}
	
}
