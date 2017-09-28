package delta;

import java.util.Arrays;

import vending_machine.VendingMachine;
import vending_machine.data.VMInput;

public class VMStateChangeFunction {
	public static void execute(VendingMachine vendingMachine, VMInput[] inputBag) {
		changeState(vendingMachine);
		Arrays.stream(inputBag).forEach(i -> handleInput(vendingMachine, i));
	}
	
	private static void changeState(VendingMachine vendingMachine) {
		
	}
	
	private static void handleInput(VendingMachine vendingMachine, VMInput input) {
		switch(input) {
			case CHANGE:
				vendingMachine.setChangePressed(true);
				break;
			case DIME:
				vendingMachine.addDime();
				break;
			case NICKEL:
				vendingMachine.addNickel();
				break;
			case QUARTER:
				vendingMachine.addQuarter();
				break;
			case WAIT:
				break;
			default:
				break;
		}
	}
}
