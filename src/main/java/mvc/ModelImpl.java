package mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ModelImpl implements Model {

    private final State state;
    private final List<Observer<Integer>> observers;
    private final Lock mutex;

    public ModelImpl() {
        this.state = new StateImpl();
        this.observers = new ArrayList<>();
        this.mutex = new ReentrantLock();
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
        try {
            this.mutex.lock();
            this.state.update();
            this.observers.forEach(o -> o.onChange(this.state.getValue()));
        } finally {
            this.mutex.unlock();
        }
    }
}
