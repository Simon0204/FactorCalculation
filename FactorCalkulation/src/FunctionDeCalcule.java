import java.util.Scanner;

public class FunctionDeCalcule {
	public static double factorCalculation(double power, double courant,
			double tension) {
		double angle = power / courant * tension;
		double factor = Math.cos(angle);
		return factor;

	}
}
