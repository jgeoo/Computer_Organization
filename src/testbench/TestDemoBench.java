package testbench;


import bench.DemoBenchmark2;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import static logging.TimeUnit.*;

public class TestDemoBench {
    public static void main(String[] args){

    ITimer timer = new Timer() ;
    ILogger log = new ConsoleLogger();
        FileLogger flog = new FileLogger();
    IBenchmark bench = new DemoBenchmark2();

    bench.initialize(1000);
    timer.start();
    bench.run(25);

    long time = timer.stop();

    log.write("Finished in",toTimeUnit(time,Nano),"sec");
    log.close();
    bench.clean();

    }
}
