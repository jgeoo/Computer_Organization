package testbench;

import bench.CPU.CPURecursionLoopUnrolling;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;

public class TestCPURecursion {
    IBenchmark bench = new CPURecursionLoopUnrolling();
    ILogger log = new ConsoleLogger();


}
