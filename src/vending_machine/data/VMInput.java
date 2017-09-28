package vending_machine.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum VMInput
{
	NICKEL('n'),
	DIME('d'),
	QUARTER('q'),
	CHANGE('c'),
	WAIT('w');
	
	public static final List<Character> INPUT_SYMBOLS = getInputSymbols();
	
	public final char INPUT_SYMBOL;
	
	VMInput(char inputSymbol) {
		INPUT_SYMBOL = inputSymbol;
	}
	
	public static VMInput getInputForSymbol(char symbol) {
		return Arrays.stream(values()).filter(i -> i.INPUT_SYMBOL == symbol).findFirst().orElse(null);
	}
	
	private static List<Character> getInputSymbols() {
		return Arrays.stream(values()).map(i -> i.INPUT_SYMBOL).collect(Collectors.toList());
	}
}
