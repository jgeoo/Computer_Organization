package bench;

import java.util.Random;

class DemoBenchmark implements IBenchmark {
    int n;
    int[] array;
    public void initialize(Object... params) {
        Random random = new Random();

        this.n = (Integer) params[0];
        this.array = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = random.nextInt(1000);
    }


    public void run(Object... params) {
        try{
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void run(){

        int size = array.length;

        for(int i = 0; i < size;i++)
            for(int j = 0; j < size - 1;j++)
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public void warmup(int scale) {

    }

    @Override
    public void warmup() {

    }

    public void cancel() {

    }

    @Override
    public void warmUp() {

    }

    public void clean() {

    }

    public String getresult() {
        return null;
    }

    @Override
    public String getResult() {
        return null;
    }
}
