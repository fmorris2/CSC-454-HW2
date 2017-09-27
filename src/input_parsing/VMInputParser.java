package input_parsing;

import java.util.Scanner;

import vending_machine.data.VMInput;

public class VMInputParser {
	private final Scanner SCANNER;
	
	public VMInputParser() {
		SCANNER = new Scanner(System.in);
	}
	
	public VMInput[] parse() {
		String userInput = SCANNER.nextLine();
		return convertStringToArrayOfInputs(userInput);
	}
	
	private VMInput[] convertStringToArrayOfInputs(String userInput) {
		return userInput.chars()
				.filter(c -> VMInput.INPUT_SYMBOLS.contains((char)c))
				.mapToObj(c -> VMInput.getInputForSymbol((char)c))
				.toArray(size -> new VMInput[size]);
	}
}
