package testbench;

import bench.CPU.CPURecursionLoopUnrolling;
import bench.IBenchmark;

import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import static logging.TimeUnit.Milli;
import static logging.TimeUnit.toTimeUnit;


public class TestCPURecursion {
    public static void main(String[] args) {
        ITimer timer=new Timer();
        ILogger log=new ConsoleLogger();
        IBenchmark bench = new CPURecursionLoopUnrolling();
        int size =20000;
        bench.initialize(size);
        timer.start();
        bench.run(true,8);
        long time = timer.stop();

        log.write("Finished in",toTimeUnit(time,Milli),"\n");
        log.write("Score is:", (double)size/time*10000000);

        bench.clean();
        log.close();

    }
}
