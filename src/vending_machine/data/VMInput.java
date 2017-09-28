package vending_machine.data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import vending_machine.VendingMachine;

public enum VMInput
{
	NICKEL('n', 5),
	DIME('d', 10),
	QUARTER('q', 25),
	CHANGE('c', 0, (vm) -> vm.setChangePressed(true)),
	WAIT('w', 0);
	
	public static final List<Character> INPUT_SYMBOLS = getInputSymbols();
	
	public final char INPUT_SYMBOL;
	public final double MONETARY_VALUE;
	public final Consumer<VendingMachine> INPUT_EFFECT;
	
	@SafeVarargs
	VMInput(char inputSymbol, double monetaryValue, Consumer<VendingMachine>... inputEffect) {
		INPUT_SYMBOL = inputSymbol;
		MONETARY_VALUE = monetaryValue;
		INPUT_EFFECT = inputEffect.length > 0 ? inputEffect[0] : monetaryValue == 0 ? (vm) -> {} : (vm) -> vm.changeCoinStock(this, 1);
	}
	
	public static VMInput getInputForSymbol(char symbol) {
		return Arrays.stream(values()).filter(i -> i.INPUT_SYMBOL == symbol).findFirst().orElse(null);
	}
	
	private static List<Character> getInputSymbols() {
		return Arrays.stream(values()).map(i -> i.INPUT_SYMBOL).collect(Collectors.toList());
	}
}
