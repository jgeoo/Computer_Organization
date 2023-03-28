package logging;

public class ConsoleLogger  implements ILogger{


    public void write(long long_parameter) {
        System.out.println(long_parameter+"\n");
    }


    public void write(String String_parameter) {
        System.out.println(String_parameter+"\n");
    }


    public void write(Object... values) {
        for (Object value : values) {
            System.out.print(value.toString() + " ");
        }
    }


    public void close() {

    }
}
