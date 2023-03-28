package bench.CPU;

import bench.IBenchmark;
import java.util.Random;
import static logging.TimeUnit.Sec;
import static logging.TimeUnit.toTimeUnit;
public class CPUFixedPoint implements IBenchmark {

    private int workload;
    private static final int ARRAY_SIZE = 1000;
    private int[] num = new int[4];
    private int[] res = new int[ARRAY_SIZE];
    private int[] a = new int[ARRAY_SIZE];
    private int[] b = new int[ARRAY_SIZE];
    private int[] c = new int[ARRAY_SIZE];
    @Override
    public void run() {

    }



    private int benchmarkIndex;

    @Override
    public void run(Object... params) {
        benchmarkIndex = (int) params[0];
        switch (benchmarkIndex) {
            case 0:
                runIntegerArithmeticTest(workload);
                break;
            case 1:
                runBranchingTest(workload);
                break;
            case 2:
                runArrayTest(workload);
                break;
            default:
                throw new IllegalArgumentException("Invalid benchmark index");
        }
    }

    @Override
    public void initialize(Object... params) {

        if (params.length != 1 || !(params[0] instanceof Integer)) {
            throw new IllegalArgumentException("Expecting a single integer argument.");
        }
        this.workload = (int) params[0];

        Random rand = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(100) + 1;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(ARRAY_SIZE);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = rand.nextInt(ARRAY_SIZE);
        }
        for (int i = 0; i < c.length; i++) {
            c[i] = rand.nextInt(100) + 1;
        }
    }

    @Override
    public void warmup(int scale) {

    }

    @Override
    public void warmup() {

    }

    private double mops;

    public double runIntegerArithmeticTest(int workload){
        long startTime = System.nanoTime();

        for (int i = 0; i < workload; i++) {
            int j = num[1] * (num[3] * num[2] - num[1] * num[0]) * (num[0] - num[3]);
            int k = num[3] * num[1] - (num[0] - num[2]) * num[3];
            int l = (num[3] - num[1]) * (num[2] + num[0]);

            int index1 = l - 2;
            int index2 = k - 2;

            if (index1 >= 0 && index1 < res.length) {
                res[index1] = j + k + l;
            }
            if (index2 >= 0 && index2 < res.length) {
                res[index2] = j * k * l;
            }

        }
        long endTime = System.nanoTime();
        double elapsedTime = toTimeUnit(endTime - startTime, Sec);
        this.mops = workload * 52 / elapsedTime / 1e6;
        return this.mops;
    }


    public double runBranchingTest(int workload){
        long startTime = System.nanoTime();

        for (int i = 0; i < workload; i++) {
            int j = num[1];
            if (j == 1) {
                j = num[2];
            } else {
                j = num[3];
            }
            if (j > 2) {
                j = num[0];
            } else {
                j = num[1];
            }
            if (j < 1) {
                j = num[1];
            } else {
                j = num[0];
            }
        }

        long endTime = System.nanoTime();
        double elapsedTime = toTimeUnit(endTime - startTime, Sec);
        this.mops = workload * 20 / elapsedTime / 1e6;
        return this.mops;
    }

    public double runArrayTest(int workload){
        long startTime = System.nanoTime();
        int operationsPerIteration = 0;

        for (int i = 0; i < workload; i++) {
            int index1 = (int) (Math.random() * ARRAY_SIZE);
            int index2 = (int) (Math.random() * ARRAY_SIZE);
            if (index1 >= 0 && index1 < ARRAY_SIZE && index2 >= 0 && index2 < ARRAY_SIZE) {
                int value = a[b[index2]];
                c[index1] = value;
                operationsPerIteration += 5;
            } else {
                operationsPerIteration += 4;
            }
        }
        long endTime = System.nanoTime();
        double elapsedTime = toTimeUnit(endTime - startTime, Sec);
        this.mops = (operationsPerIteration * workload) / elapsedTime / 1e6;
        return this.mops;
    }

    @Override
    public void warmUp() {

    }

    @Override
    public void clean() {

    }

    @Override
    public String getresult() {
        return null;
    }

    @Override
    public void cancel() {

    }

    @Override
    public String getResult() {

        switch (benchmarkIndex){
            case 0:
                return mops + " MOPS for runIntegerArithmeticTest";
            case 1:
                return mops + " MOPS for runBranchingTest";
            case 2:
                return mops + " MOPS for runArrayTest";
            default:
                return String.valueOf(mops);
        }

    }
}
