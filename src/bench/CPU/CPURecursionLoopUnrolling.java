package bench.CPU;

import bench.IBenchmark;

public class CPURecursionLoopUnrolling implements IBenchmark {
    @Override
    public void run(Object... options) {
        if(options[0].equals(0)){
            recursive(1L, (Long) options[1],0);
        }else {
           // recursiveUnrolled(1,unrollLevel,options[1],0);
        }
    }

    private long recursive(long start,long size,int counter){
     try {
         if (start <= size) {
             if (isPrime(start)) {
                 recursive(start + 1, size, counter + 1);
                 return start;
             } else {
                 recursive(start + 1, size, counter + 1);
             }
         }
     }catch (StackOverflowError e){
         System.out.println("Reached nr"+start+"/"+size+"after "+counter+"calls");
     }
     return 0;
    }
    public boolean isPrime(long x){
        if(x <= 2){
            return true;
        }
        for(int i = 2; i <= Math.sqrt(x); i++)
            if(x % i == 0)
                return  false;
    return true;
    }
    private long recursiveUnrolled(long start,int unrollLevel,int size, int counter){

    return 0;
    }


    @Override
    public void run() {

    }

    @Override
    public void initialize(Object... values) {

    }

    @Override
    public void warmup(int scale) {

    }

    @Override
    public void warmup() {

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
    public String getresult() {
        return null;
    }

    @Override
    public String getResult() {
        return null;
    }
}
