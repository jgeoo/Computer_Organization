package testbench;

import bench.IBenchmark;
import bench.CPU.CPUThreadedRoots;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

class TestCPUThreadsRoots {

    public static void main(String[] args){
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();

        TimeUnit timeUnit = TimeUnit.Sec;

        IBenchmark bench = new CPUThreadedRoots();
        int workload = 50000000;
        bench.initialize(workload);
        bench.warmUp();

        long totalTime = 0;

        for(int i = 1; i <= 128; i *= 2){
            timer.start();
            bench.run(i);
            long time = timer.stop();
            log.write("[t="+i+"] finished in", time, timeUnit);
            totalTime += time;

            double score = (double) workload/( time * 10E-5* i);
            log.write(score);

            System.out.println();
        }

        log.write("Total finished in ", totalTime, timeUnit);
        log.write("Average time: ", totalTime/8, timeUnit);
        //double score = (double) workload/( totalTime  * 32);
        //log.write(score);

        //log.write(bench.getResult());
        bench.clean();
        log.close();
    }

}
