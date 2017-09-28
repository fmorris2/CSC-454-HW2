package vending_machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import vending_machine.data.VMInput;

public class ReadableVendingMachine {
	private static final int STARTING_COIN_AMOUNT = 0;
	
	protected Map<VMInput, Integer> MONEY_STOCK;
	protected double value;
	protected boolean isChangePressed;
	
	public ReadableVendingMachine() {
		initializeStartingStock();
	}
	
	public int getCoinStock(VMInput input) {
		return MONEY_STOCK.getOrDefault(input, 0);
	}

	public double getValue() {
		return value;
	}
	
	public boolean isChangePressed() {
		return isChangePressed;
	}
	
	private void initializeStartingStock() {
		MONEY_STOCK = new HashMap<>();
		Arrays.stream(VMInput.values())
			.filter(input -> input.MONETARY_VALUE > 0)
			.forEach(coin -> MONEY_STOCK.put(coin, STARTING_COIN_AMOUNT));
	}
}
