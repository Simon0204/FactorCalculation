import java.io.Console;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double power = readPowerFromConsole();
		double voltage = readVoltageConsole();
		double current = currentConsole();
		double factor = factorCalculation(power, current, voltage);
		printFactorInConsole(factor);
	}

	public static double factorCalculation(double power, double current,
			double voltage) {
		double angle = power / current * voltage;
		double factor = Math.cos(angle);
		return factor;
	}

	public static double readPowerFromConsole() {
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter power Value:  ");
		double s = in.nextInt();
		return s;

	}

	public static double readVoltageConsole() {
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter voltage Value:  ");
		double u = in.nextInt();
		return u;

	}

	public static double currentConsole() {
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter current Value:  ");
		double i = in.nextInt();
		return i;

	}

	public static void printFactorInConsole(double i) {
		Scanner in = new Scanner(System.in);
		System.out.println("Calcul Console: " + i);

	}

}
