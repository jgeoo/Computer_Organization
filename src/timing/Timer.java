package timing;

public class Timer implements ITimer {
    long elapsedTime=0,totalTime=0,start=0,end=0;
    public void start(){
        elapsedTime=0;
        totalTime=0;
        end=0;
        start = System.nanoTime();
    }
    public long stop(){
        end = System.nanoTime();
        totalTime += end-start;
        return totalTime;
    }
    public void resume(){
        start=System.nanoTime();
    }
    public long pause(){
        end = System.nanoTime();
        elapsedTime= end-start;
        totalTime+= elapsedTime;
        return elapsedTime;
    }
}