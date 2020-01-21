import java.util.Scanner;

public class SyntaxAnalyzer {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj symbole: ");
        String symbols = scan.nextLine();
        Utilities.charArray = symbols.toCharArray();
        Utilities.init();
        boolean result = Utilities.start();
        Utilities.printResult(result);
	}

}
