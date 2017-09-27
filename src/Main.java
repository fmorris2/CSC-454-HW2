import input_parsing.VMInputParser;
import vending_machine.VendingMachine;


public class Main
{
	public static void main(String[] args)
	{
		VendingMachine vendingMachine = new VendingMachine();
		VMInputParser inputParser = new VMInputParser();
		
		while(true) {
			System.out.println(inputParser.parse().length);
		}
	}

}
