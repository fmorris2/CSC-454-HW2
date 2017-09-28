package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vending_machine.ReadableVendingMachine;
import vending_machine.data.VMInput;
import vending_machine.data.VMOutput;

public class ChangeUtils {
	private static double totalChangeValueNeeded;
	
	public static VMOutput[] calculateChange(ReadableVendingMachine vendingMachine) {
		totalChangeValueNeeded = vendingMachine.getValue();
		List<VMOutput> change = calculateChangeForValue(vendingMachine);
		return change.size() == 0 ? new VMOutput[]{VMOutput.NOTHING} : change.toArray(new VMOutput[change.size()]);
	}
	
	private static List<VMOutput> calculateChangeForValue(ReadableVendingMachine vendingMachine) {
		List<VMInput> tempChange = new ArrayList<>();
		Arrays.stream(VMInput.values())
			.filter(input -> input.MONETARY_VALUE > 0 && vendingMachine.getCoinStock(input) > 0)
			.sorted((c1, c2) -> (int)(c2.MONETARY_VALUE - c1.MONETARY_VALUE))
			.forEachOrdered(coinType -> {
				if(totalChangeValueNeeded >= coinType.MONETARY_VALUE) {
					int numCoinsToBeUsed = (int)(totalChangeValueNeeded / coinType.MONETARY_VALUE); //truncate any decimal
					for(int i = 0; i < numCoinsToBeUsed && i < vendingMachine.getCoinStock(coinType); i++) {
						tempChange.add(coinType);
						totalChangeValueNeeded -= coinType.MONETARY_VALUE;
					}
				}
			});
		
		if(totalChangeValueNeeded > 0) {
			throw new CannotProduceChangeException();
		}
			
		List<VMOutput> change = tempChange.stream()
				.map(input -> Arrays.stream(VMOutput.values()).filter(o -> o.name().equals(input.name())).findFirst().get())
				.collect(Collectors.toList());
		
		return change;
	}
	
	static class CannotProduceChangeException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
