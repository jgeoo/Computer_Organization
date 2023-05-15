package bench.CPU;

import bench.IBenchmark;

public class CPURecursionLoopUnrolling implements IBenchmark {
    private boolean isUnrolled;
    private int size;
    private int start;
    private int counter;
    private int unrollLevel;
    private static long sum=0;
    private int counter2;
    private long sumOfPrimes;
    public void run(Object...params){
        isUnrolled=(boolean)params[0];
        if(isUnrolled){
                unrollLevel=(Integer)params[1];
                sumOfPrimes=recursiveUnrolled(start,unrollLevel,size,counter);
                System.out.println("Nr of calls: "+counter2);
            }
        else {
            sumOfPrimes = recursive(start, size,counter);
            System.out.println("Nr of calls: "+counter2);
        }
    }

    @Override
    public void run() {

    }

    public void initialize(Object...param){
        this.size=(Integer)param[0];
        counter=0;
        start=1;
    }

    @Override
    public void warmup(int scale) {

    }

    @Override
    public void warmup() {

    }

    public int recursiveUnrolled(long start,int unrollLevel,long size,int counter){
        try {
            sum=0;
            counter=counter+1;

            counter2=counter;
            for(int i=0;i<unrollLevel;i++) {
                long prime = SearchPrime(start+i);

                if (prime >= size) {

                    return (int)sum;
                }
                sum = sum + prime;
                if (i == unrollLevel - 1) {
                    start+=unrollLevel;
                }

            }

            return (int)sum+recursiveUnrolled(start+1,unrollLevel,size,counter);
        }catch (StackOverflowError e) {
            //  System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
            StringBuilder string=new StringBuilder();
            string.append("Reached nr ");
            string.append(start);
            string.append("/");
            string.append(size);
            string.append(" after ");
            string.append(counter2);
            string.append(" calls");
            System.out.println(string);
            return 0;
        }
    }
    public long SearchPrime(long x){
        if(x==1)
            return 0;
        if (x <= 2)
            return x;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return 0;
        }
        return x;
    }
    public int getCounter(){
        return this.counter;
    }

    public long recursive(long start,long size,int counter){
        try {

            long prime = SearchPrime(start);

            counter++;
            counter2=counter;
            if (prime >= size) {

                return 0;
            } else {
                return prime + recursive(start+1, size, counter);
            }
        }catch (StackOverflowError e) {
            StringBuilder string=new StringBuilder();
            string.append("Reached nr ");
            string.append(start);
            string.append("/");
            string.append(size);
            string.append(" after ");
            string.append(counter2);
            string.append(" calls");
            System.out.println(string);
            return 0;
        }
    }



    public void clean(){

    }
    @Override
    public String getResult() {
        return String.valueOf(sum);
    }

    public void cancel(){

    }

    @Override
    public void warmUp() {

    }

}
