package testbench;

import bench.IBenchmark;
import bench.CPU.CPUFixedPoint;
import logging.ConsoleLogger;
import logging.ILogger;

public class TestCPUFixedPoint {
    public static void main(String[] args){
        ILogger log = new ConsoleLogger();

        IBenchmark bench = new CPUFixedPoint();
        bench.initialize(10000);

        bench.run(0);
        log.write(bench.getResult());

        bench.clean();
        log.close();
    }
}
