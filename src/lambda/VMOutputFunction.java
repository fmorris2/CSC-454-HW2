package lambda;

import utils.ChangeUtils;
import vending_machine.ReadableVendingMachine;
import vending_machine.VendingMachine;
import vending_machine.data.VMOutput;

public class VMOutputFunction {
	
	public static VMOutput[] execute(ReadableVendingMachine vendingMachine) {
		
		if(vendingMachine.isChangePressed() && vendingMachine.getValue() > 0) {
			return ChangeUtils.calculateChange(vendingMachine);
		}
		
		if(vendingMachine.getValue() >= VendingMachine.COFFEE_PRICE) {
			return dispenseCoffee(vendingMachine);
		}
		
		return new VMOutput[]{VMOutput.NOTHING};
	}
	
	private static VMOutput[] dispenseCoffee(ReadableVendingMachine vendingMachine) {
		int numCoffee = (int)(vendingMachine.getValue() / VendingMachine.COFFEE_PRICE);
		VMOutput[] coffee = new VMOutput[numCoffee];
		for(int i = 0; i < numCoffee; i++) {
			coffee[i] = VMOutput.COFFEE;
		}
		
		return coffee;
	}
}
