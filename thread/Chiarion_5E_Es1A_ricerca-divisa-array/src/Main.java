import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        /* variable declaration */
        int threadNumber, searchNumber;
        long startingTime, endingTime;
        /* create scanner */
        Scanner scanner = new Scanner(System.in);
        /* create random array with numbers */
        final int ARRAYSIZE = 1000000;
        int[] array = new int[ARRAYSIZE];
        Random random = new Random();
        for(int i = 0;i<array.length;i++)
            array[i] = random.nextInt(0,1000);

        /* ask in input the number to search
        * and the thread */
        System.out.println("Inserisci il numero da ricercare: ");
        searchNumber = scanner.nextInt();
        do{
            System.out.println("Inserisci il numero di thread: ");
            threadNumber = scanner.nextInt();
        }while(threadNumber < 1 || threadNumber > array.length);

        /* create the array with threads
        * and separate the various indexes to search */
        Search[] threads = createThread(array, searchNumber, threadNumber);

        startingTime = System.currentTimeMillis();
        /* start threads */
        for(int i=0;i<threads.length && threads[i]!=null;i++)
            threads[i].start();

        /* end threads */
        for(int i=0;i<threads.length && threads[i]!=null;i++){
            try {
                threads[i].join();
            }catch(InterruptedException e){}
        }
        endingTime = System.currentTimeMillis();

        /* report the result */
        for(int i=0;i<threads.length && threads[i]!=null;i++)
            System.out.printf("Il thread %d ha trovato %d occorrenze\n", (i+1), threads[i].getOccurencesNumber());

        System.out.println("Esecuzione completata in: "+Duration.ofMillis(startingTime-endingTime).toString());
    }

    /* function to separate the numbers
    * into multiple threads for research */
    private static Search[] createThread(int[] array, int searchNumber, int threadNumber){
        /* create array and variables */
        Search[] threads = new Search[threadNumber];
        int startingIndex = 0, endingIndex = 0;

        for(int i=0;i<threadNumber && endingIndex<array.length;i++){
            startingIndex = endingIndex;
            endingIndex += Math.max(array.length/threadNumber, Math.max(array.length%threadNumber, 1));
            threads[i] = new Search(array, startingIndex, endingIndex, searchNumber);
        }

        return threads;
    }
}
