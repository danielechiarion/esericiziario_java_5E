public class Main {
    public static void main(String[] args) {
        /* define the objects for the execution of the program */
        Biblioteca biblioteca = new Biblioteca(5);
        final int READERS = 10; // constant for the number of readers
        Thread[] threads = new Thread[READERS];
        String[] nomiLettori = {"Mario", "Giovanna", "Luca", "Lucia", "Anna", "Paolo", "Silvia", "Giulia", "Daniele Supremo", "Malloc"};

        /* create, starts and wait
        * for termination of threads */
        for(int i=0;i<READERS;i++)
            threads[i] = new Thread(new Lettore(biblioteca, nomiLettori[i]));
        for(Thread singleThread : threads)
            singleThread.start();
        for(Thread singleThread : threads){
            try{
                singleThread.join();
            }catch(InterruptedException e){}
        }
    }
}
