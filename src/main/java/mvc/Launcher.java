package mvc;

public class Launcher {

    static public void main(String[] args) {
		final Model model = new ModelImpl();
		final Controller controller = new ControllerInput(model);
		final InputSource inputSourceGUI = new InputSourceGUI();
		final InputSource inputSourceStdIn = new InputSourceStdIn();
		new AutonomousController(model);
		inputSourceGUI.attachController(controller);
		inputSourceStdIn.attachController(controller);
		model.attach(new ViewStdOut());
		model.attach(new ViewGUI());
	}

}
