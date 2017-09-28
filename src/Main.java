import java.util.Arrays;

import delta.VMStateChangeFunction;
import input_parsing.VMInputParser;
import lambda.VMOutputFunction;
import vending_machine.VendingMachine;
import vending_machine.data.VMInput;
import vending_machine.data.VMOutput;


public class Main
{
	public static void main(String[] args)
	{
		int tick = 1;
		VendingMachine vendingMachine = new VendingMachine();
		VMInputParser inputParser = new VMInputParser();
		
		while(true) {
			VMOutput[] output = VMOutputFunction.execute(vendingMachine);
			System.out.println("Output at tick " + tick + ": ");
			Arrays.stream(output).forEach(o -> System.out.println("\t"+o));
			
			VMInput[] input = inputParser.parse();
			VMStateChangeFunction.execute(vendingMachine, input);
			tick++;
		}
	}

}
