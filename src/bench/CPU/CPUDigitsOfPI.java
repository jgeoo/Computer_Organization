package bench.CPU;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Random;

public class CPUDigitsOfPI implements IBenchmark {

    public void warmup(int scale) {
        int iterations = 10; // number of iterations
        BigDecimal a = BigDecimal.ONE;
        BigDecimal b = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.sqrt(2)), scale, RoundingMode.HALF_UP);
        BigDecimal t = BigDecimal.valueOf(0.25);
        BigDecimal p = BigDecimal.ONE;

        for (int i = 0; i < iterations; i++) {
            BigDecimal aNext = a.add(b).divide(BigDecimal.valueOf(2), scale, RoundingMode.HALF_UP);
            BigDecimal bNext = BigDecimal.valueOf(Math.sqrt(a.doubleValue() * b.doubleValue())).setScale(100, RoundingMode.HALF_UP);
            BigDecimal tNext = t.subtract(p.multiply(a.subtract(aNext).pow(2)));
            BigDecimal pNext = p.multiply(BigDecimal.valueOf(2));

            a = aNext;
            b = bNext;
            t = tNext;
            p = pNext;
        }

        BigDecimal pi = a.add(b).pow(2).divide(t.multiply(BigDecimal.valueOf(4)), scale, RoundingMode.HALF_UP);
    }

    @Override
    public void warmup() {

    }

    @Override
    public void run(Object... options) {
        int option = (Integer) options[0];
        int noofdigits = (Integer) options[1];
        switch (option) {
            case 0:
                computePiMagically();
                break;
            case 1:
                computePiByGuessing();
                break;
            case 2:
                computePiUsingMaths(noofdigits);
                break;
            default:
                try {
                    throw new IllegalAccessException("Option is invalid, must be between 0-2");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

        }
    }

    public void computePiByGuessing() {
    BigDecimal Pi_guessing = new BigDecimal("3.14");
        Random rand = new Random();
        int i = 0;
       while(i < 10){
            int randomInt = rand.nextInt(10);
            Pi_guessing = Pi_guessing.add(new BigDecimal(randomInt));
            i++;
    }

        System.out.println(Pi_guessing);
    }

    public void computePiMagically() {
        BigDecimal PI = new BigDecimal(3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679);
        System.out.println(PI);
    }

    public void computePiUsingMaths(int scale) {
        int iterations = 10; // number of iterations
        BigDecimal a = BigDecimal.ONE;
        BigDecimal b = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.sqrt(2)), scale, RoundingMode.HALF_UP);
        BigDecimal t = BigDecimal.valueOf(0.25);
        BigDecimal p = BigDecimal.ONE;

        for (int i = 0; i < iterations; i++) {
            BigDecimal aNext = a.add(b).divide(BigDecimal.valueOf(2), scale, RoundingMode.HALF_UP);
            BigDecimal bNext = BigDecimal.valueOf(Math.sqrt(a.doubleValue() * b.doubleValue())).setScale(100, RoundingMode.HALF_UP);
            BigDecimal tNext = t.subtract(p.multiply(a.subtract(aNext).pow(2)));
            BigDecimal pNext = p.multiply(BigDecimal.valueOf(2));

            a = aNext;
            b = bNext;
            t = tNext;
            p = pNext;
        }

        BigDecimal pi = a.add(b).pow(2).divide(t.multiply(BigDecimal.valueOf(4)), scale, RoundingMode.HALF_UP);
        System.out.println(pi);
    }
    @Override
    public void run() {

    }

    @Override
    public void initialize(Object... values) {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void clean() {

    }
    @Override
    public String getResult() {
        return null;
    }
}
