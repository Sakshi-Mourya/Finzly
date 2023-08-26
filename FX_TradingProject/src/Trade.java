public class Trade {

	private static int tradeNo = 0;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double rate;
    
    public Trade(String currencyPair, String customerName, double amount, double rate) {
		super();
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.rate = rate;
		tradeNo++;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public double getAmount() {
		return amount;
	}

	public double getRate() {
		return rate;
	}

	@Override
	public String toString() {
		
	    String newamount1 = "INR " + amount*rate;
	    return tradeNo + "\t" + currencyPair + "\t" + customerName + "\t" + newamount1 + "\t" + rate;
	}
    
}
