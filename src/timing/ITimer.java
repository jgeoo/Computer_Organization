package timing;

public interface ITimer {
    void start();
    long stop();
    long pause();
    void resume();

}
