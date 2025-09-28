package mvc;

public class ViewStdOut implements Observer<Integer> {

    @Override
    public void onChange(final Integer value) {
        log("State value: " + value);
    }

    private void log(final String msg) {
        System.out.println("[Output] " + msg);
    }
}
