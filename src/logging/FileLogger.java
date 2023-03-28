package logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileLogger implements ILogger{
    String filename = "output.txt";
    FileWriter  writer;
    {
        try {
            writer = new FileWriter(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public FileLogger(){
        File file = new File("Output.txt");
        if (!(file.exists() && file.isFile())){
            System.out.println("File does not exist");
        }

    }
    public void write(long long_parameter) {
        try {
            writer.write( Long.toString(long_parameter));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String String_parameter) {
        try {
            writer.write(String_parameter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(Object... values) {
        try {
            for(Object value : values) {
                writer.write(value.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

