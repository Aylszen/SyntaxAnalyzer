import com.sun.xml.internal.messaging.saaj.util.CharReader;

public class Utilities {

	private static String firstO = "*:+-^";
	private static String firstC = "0123456789";
	private static String firstL = "0123456789";
	private static String firstLPrim = "0123456789E";
	private static String firstR = "0123456789";
	private static String firstRPrim = ".E";
	private static int iterator = 0;
	public static char[] charArray = new char[100];
	private static char currentSymbol;

	public static boolean funcR() {
		if (isInFirst(firstR)) {
			if (funcL() && funcRPrim()) {
				return true;
			}

		} else {
			return false;
		}
		return false;

	}

	public static boolean funcRPrim() {
		if (isInFirst(firstRPrim)) {
			loadSymbol();
			if (funcL()) {
				return true;
			}

		} else if (isInFirstEpsilon(firstRPrim)) {
			return true;
		}
		return false;
	}

	public static boolean funcL() {
		if (isInFirst(firstLPrim)) {
			if (funcC() && funcLPrim()) {
				return true;
			}

		} else {
			return false;
		}
		return false;

	}

	public static boolean funcLPrim() {
		if (isInFirst(firstLPrim)) {
			if (funcL()) {
				return true;
			}

		} else if (isInFirstEpsilon(firstLPrim)) {
			//unloadSymbol();
			return true;
		}

		return false;
	}

	public static boolean funcC() {
		if (isInFirst(firstC)) {
			if (loadSymbol()) {
				return true;
			}
		}
		return false;
	}

	public static boolean funcO() {
		if (isInFirst(firstO)) {
			if (loadSymbol()) {
				return true;
			}

		}
		return false;
	}

	public static boolean loadSymbol() {
		if (iterator + 1 < charArray.length) {
			iterator++;
			currentSymbol = charArray[iterator];
			System.out.println("Current char(load): " + currentSymbol);
			return true;
		} else {
			System.exit(0);
			return false;
		}
	}

	public static void unloadSymbol() {
		iterator--;
		currentSymbol = charArray[iterator];
		System.out.println("Current char(unload): " + currentSymbol);
	}

	public static void init() {
		iterator = 0;
		currentSymbol = charArray[iterator];
		System.out.println("Current char: " + currentSymbol);
	}

	public static boolean isInFirst(String first) {
		if (first.indexOf(currentSymbol) != -1) {
			return true;
		}
		return false;
	}

	public static boolean isInFirstEpsilon(String first) {
		if (first.indexOf('E') != -1) {
			return true;
		}
		return false;
	}

}
