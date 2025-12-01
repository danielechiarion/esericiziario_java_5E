import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        /* variable declaration */
        int threadNumber;
        /* create scanner */
        Scanner scanner = new Scanner( System.in );
        /* create random array with numbers */
        final int ARRAYSIZE = 1000000;
        int[] array = new int[ARRAYSIZE];
        SharedResource sharedResource = new SharedResource(array); // created the shared resource

        /* ask in input the number to search
         * and the thread */
        do {
            System.out.println( "Inserisci il numero di thread: " );
            threadNumber = scanner.nextInt();
        } while (threadNumber < 1 || threadNumber > array.length);


        /* create the threads based on
        * the number given */
        Thread[] threads = new Thread[threadNumber];
        for(int i=0;i<threadNumber;i++)
                threads[i] = new Thread(new ThreadExample(sharedResource, i));

        /* start the thread and wait them till the end */
        for(Thread singleThread : threads)
            singleThread.start();
        for(Thread singleThread : threads) {
            try {
                singleThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
