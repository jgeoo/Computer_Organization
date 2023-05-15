package bench;

public interface IBenchmark {
    void run(Object... options);
    void run();

    void initialize(Object ... values);

    void warmup(int scale);
    void warmup();

    void cancel();

    void warmUp();

    void clean();

    String getResult();
}
