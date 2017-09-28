package vending_machine;

import vending_machine.data.VMInput;

public class VendingMachine extends ReadableVendingMachine {
	public static double COFFEE_PRICE = 100;
	
	public void setChangePressed(boolean isChangePressed) {
		this.isChangePressed = isChangePressed;
	}
	
	public void purchaseCoffee() {
		value -= COFFEE_PRICE;
	}
	
	public void changeCoinStock(VMInput input, int amount) {
		if(input.MONETARY_VALUE > 0) {
			value += input.MONETARY_VALUE * amount;
			MONEY_STOCK.put(input, MONEY_STOCK.getOrDefault(input, 0) + amount);
		}
	}
}
