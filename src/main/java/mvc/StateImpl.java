package mvc;

public class StateImpl implements State {

    private int value = 0;

    @Override
    public void update() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
