package logging;

public interface ILogger {
    void write(long long_parameter);
    void write(String String_parameter);

    void write(Object... values);

    void close();

}
