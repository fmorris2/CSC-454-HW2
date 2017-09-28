package lambda;

import utils.ChangeUtils;
import vending_machine.ReadableVendingMachine;
import vending_machine.VendingMachine;
import vending_machine.data.VMOutput;

public class VMOutputFunction {
	
	public static VMOutput[] execute(ReadableVendingMachine vendingMachine) {
		
		if(vendingMachine.isChangePressed()) {
			return ChangeUtils.calculateChange(vendingMachine);
		}
		
		if(vendingMachine.getValue() >= VendingMachine.COFFEE_PRICE) {
			return new VMOutput[]{VMOutput.COFFEE};
		}
		
		return new VMOutput[]{VMOutput.NOTHING};
	}
}
