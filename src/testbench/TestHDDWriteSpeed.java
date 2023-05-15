package testbench;

import bench.IBenchmark;
import bench.HDD.HDDWriteSpeed;

public class TestHDDWriteSpeed {
    public static void main(String[] args){
        IBenchmark bench = new HDDWriteSpeed();
        bench.run("fb", true);
    }
}
