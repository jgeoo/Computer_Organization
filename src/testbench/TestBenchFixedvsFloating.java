package testbench;

import bench.CPU.CPUFixedvsFloating;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import static bench.CPU.NumberRepresentation.FLOATING;
import static bench.CPU.NumberRepresentation.*;
import static logging.TimeUnit.*;

public class TestBenchFixedvsFloating {



    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = /* new FileLogger("bench.log"); */new ConsoleLogger();


        IBenchmark bench = new CPUFixedvsFloating();
        bench.initialize(10000000);
        bench.warmup();

        timer.start();
        bench.run(FIXED);
		//bench.run(FLOATING);
        long time = timer.stop();
        log.write("Finished in",toTimeUnit(time,Sec));
        System.out.println();
        log.write("Result is", ((CPUFixedvsFloating) bench).getResult());

        bench.clean();
        log.close();
    }
}
