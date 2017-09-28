package vending_machine;

public class ReadableVendingMachine {
	private static final int STARTING_COIN_AMOUNT = 5;
	
	protected int nickels, dimes, quarters;
	protected double value;
	protected boolean isChangePressed;
	
	public ReadableVendingMachine() {
		nickels = STARTING_COIN_AMOUNT;
		dimes = STARTING_COIN_AMOUNT;
		quarters = STARTING_COIN_AMOUNT;
	}
	
	public int getNickels() {
		return nickels;
	}

	public int getDimes() {
		return dimes;
	}

	public int getQuarters() {
		return quarters;
	}

	public double getValue() {
		return value;
	}
	
	public boolean isChangePressed() {
		return isChangePressed;
	}
}
