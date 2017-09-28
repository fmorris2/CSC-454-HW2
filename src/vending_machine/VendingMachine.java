package vending_machine;

public class VendingMachine extends ReadableVendingMachine {
	public static double COFFEE_PRICE = 1.00;
	
	public void setChangePressed(boolean isChangePressed) {
		this.isChangePressed = isChangePressed;
	}
	
	public void addNickel() {
		nickels++;
		value += .05;
	}
	
	public void addDime() {
		dimes++;
		value += .10;
	}
	
	public void addQuarter() {
		quarters++;
		value += .25;
	}
	
	public void removeNickel() {
		nickels--;
		value -= .05;
	}
	
	public void removeDime() {
		dimes--;
		value -= .10;
	}
	
	public void removeQuarter() {
		quarters--;
		value -= .25;
	}
}
