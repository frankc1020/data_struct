package com.y3.javaAndAssignModel.java8.stream;


import java.util.concurrent.RecursiveTask;

/**
 * @author admin
 * @title: ForkJoinCalculate
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/2 16:23
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{

    private static  final  long THRESHOLD = 10000;

    private long start;

    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end -start;
        if(length < THRESHOLD){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();
            return  left.join() + right.join();
        }
    }
}
