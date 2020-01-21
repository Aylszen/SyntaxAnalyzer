import java.util.Scanner;

public class SyntaxAnalyzer {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj symbole: ");
        String symbols = scan.nextLine();
        Utilities.loadData(symbols);
        Utilities.init();
        boolean result = Utilities.start();
        Utilities.printResult(result);
        scan.close();
	}

}
