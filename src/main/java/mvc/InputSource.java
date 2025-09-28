package mvc;

interface InputSource {
    void attachController(Controller controller);
    void detachController(Controller controller);
}
