package vending_machine;

public class VendingMachine {
	private static final int STARTING_COIN_AMOUNT = 5;
	
	private int nickels, dimes, quarters;
	private double value;
	private boolean isChangePressed;
	
	public VendingMachine() {
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
	
	public void addToValue(double amount) {
		value += amount;
	}
	
	public void removeFromValue(double amount) {
		value -= amount;
	}
	
	public boolean isChangePressed() {
		return isChangePressed;
	}
	
	public void setChangePressed(boolean isChangePressed) {
		this.isChangePressed = isChangePressed;
	}
	
	public void addNickel() {
		nickels++;
	}
	
	public void addDime() {
		dimes++;
	}
	
	public void addQuarter() {
		quarters++;
	}
	
	public void removeNickel() {
		nickels--;
	}
	
	public void removeDime() {
		dimes--;
	}
	
	public void removeQuarter() {
		quarters--;
	}
}
