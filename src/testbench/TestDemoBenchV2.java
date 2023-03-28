package testbench;

import bench.DemoBenchmark2;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

import static logging.TimeUnit.*;

public class TestDemoBenchV2 {
    public static void  main(String[] args){
        final int workload = 10000;
        ITimer timer = new Timer() ;
        ILogger log = new ConsoleLogger();
        FileLogger flog = new FileLogger();
        IBenchmark bench = new DemoBenchmark2();

        bench.initialize(workload);
        timer.start();
        bench.run();

        long time = timer.stop();

        for(int i = 0; i< 12;i++){
            timer.resume();
            bench.run();
            time =  timer.pause();
            log.write("Run " + i +":",toTimeUnit(time,Sec)+"\n");

        }
        log.write("Finished in", toTimeUnit(time,Nano));
        log.close();

    }
}
