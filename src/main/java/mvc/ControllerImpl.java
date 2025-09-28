package mvc;

public class ControllerImpl implements Controller {

    private final Model model;

    public ControllerImpl(final Model model) {
        this.model = model;
    }

    @Override
    public void changeState() {
        this.model.update();
    }
}
