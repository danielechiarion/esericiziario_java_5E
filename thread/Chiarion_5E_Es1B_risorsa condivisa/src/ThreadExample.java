public class ThreadExample implements Runnable{
    /* defining attributes */
    private SharedResource sharedResource;
    private int number;

    /* constructor method */
    public ThreadExample(SharedResource sharedResource, int number){
        this.sharedResource = sharedResource;
        this.number = number;
    }

    /* running function to count occurences */
    @Override
    public void run(){
        this.sharedResource.populateArray(this.number);
    }
}
