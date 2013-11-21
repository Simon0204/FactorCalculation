import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTExample {

	private Text voltageTextFild;
	private Text courantTextFild;
	private Text powerTextFild;
	private Label printFacter;

	public void createUIElements(Shell shell) {
		createPussianceUI(shell);

		createCurantUI(shell);

		createPowerUI(shell);

		createResultUI(shell);

		createButtonOk(shell);

	}

	private void createButtonOk(Shell shell) {
		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");

		ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				double factor = calculateFactorPower();

				printFactor(factor);

			}

		});

	}

	private double calculateFactorPower() {
		double powerDouble = retrievePower();
		
		double tensionDouble = retrieveTension();
		
		double courantDouble = retrieveCourant();

		double factor = FunctionDeCalcule.factorCalculation(powerDouble,
				courantDouble, tensionDouble);

		System.out.println("OK");

		return factor;
	}

	private double retrieveCourant() {
		String courant = courantTextFild.getText();
		double courantDouble = Double.parseDouble(courant);
		return courantDouble;
	}

	private double retrieveTension() {
		String tension = voltageTextFild.getText();
		double tensionDouble = Double.parseDouble(tension);
		return tensionDouble;
	}

	private double retrievePower() {
		String power = powerTextFild.getText();
		double powerDouble = Double.parseDouble(power);
		return powerDouble;
	}

	private void printFactor(double facter) {
		String factorString = String.valueOf(facter);

		printFacter.setText("Facter de calcule   " + factorString);
	}

	private void createResultUI(Shell shell) {
		printFacter = new Label(shell, SWT.NONE);
		printFacter.setText("Facter de calcule                 ");
	}

	private void createPowerUI(Shell shell) {
		Label enterTantion = new Label(shell, SWT.NONE);
		enterTantion.setText("Enter Tantion:");
		voltageTextFild = new Text(shell, SWT.BORDER);
	}

	private void createCurantUI(Shell shell) {
		Label enterCourant = new Label(shell, SWT.NONE);
		enterCourant.setText("Enter Courant:");
		courantTextFild = new Text(shell, SWT.BORDER);
	}

	private void createPussianceUI(Shell shell) {
		Label enterPuissance = new Label(shell, SWT.NONE);
		enterPuissance.setText("Enter Puissance:");
		powerTextFild = new Text(shell, SWT.BORDER);
	}

	public void applyGridLayout(Shell shell) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		shell.setLayout(gridLayout);
	}

	public void openShell() {
		Display display = new Display();
		final Shell shell = new Shell(display);

		applyGridLayout(shell);

		createUIElements(shell);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
