package mvc;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private final State state;
    private final List<Observer<Integer>> observers;

    public ModelImpl() {
        this.state = new StateImpl();
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(final Observer<Integer> observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(final Observer<Integer> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void update() {
        this.state.update();
        this.observers.forEach(o -> o.onChange(this.state.getValue()));
    }
}
