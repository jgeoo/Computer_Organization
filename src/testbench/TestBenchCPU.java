package testbench;

import bench.CPU.CPUDigitsOfPI;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

import static logging.TimeUnit.*;

public class TestBenchCPU {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPI();

        timer.start();
        bench.warmup(10000);
        long time;
        time = timer.stop();
        log.write("Warmup finished in " , toTimeUnit(time,Sec),"Seconds");
        System.out.println("");
        timer.start();
        bench.run(2,1000000);
        time = timer.stop();

        log.write("Finished in",toTimeUnit(time,Sec),"");
        bench.clean();
        log.close();

    }
}
