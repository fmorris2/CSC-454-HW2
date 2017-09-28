package delta;

import java.util.Arrays;

import utils.ChangeUtils;
import vending_machine.VendingMachine;
import vending_machine.data.VMInput;
import vending_machine.data.VMOutput;

public class VMStateChangeFunction {
	public static void execute(VendingMachine vendingMachine, VMInput[] inputBag) {
		changeState(vendingMachine);
		Arrays.stream(inputBag).forEach(i -> i.INPUT_EFFECT.accept(vendingMachine));
	}
	
	private static void changeState(VendingMachine vendingMachine) {
		if(vendingMachine.isChangePressed()) {
			VMOutput[] change = ChangeUtils.calculateChange(vendingMachine);
			if(change[0] != VMOutput.NOTHING) {
				Arrays.stream(change)
					.map(output -> Arrays.stream(VMInput.values()).filter(i -> i.name().equals(output.name())).findFirst().get())
					.forEach(coin -> vendingMachine.changeCoinStock(coin, -1));
			}
			vendingMachine.setChangePressed(false);
		}
		else if(vendingMachine.getValue() >= VendingMachine.COFFEE_PRICE) {
			vendingMachine.purchaseCoffee();
		}
	}
}
