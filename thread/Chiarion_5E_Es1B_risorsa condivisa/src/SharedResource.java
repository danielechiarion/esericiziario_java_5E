public class SharedResource {
    private int[] array;

    public SharedResource(int[] array){
        this.array = array;
    }

    public void populateArray(int number){
        for(int i=0;i<array.length;i++){
            this.array[i] = number;
            System.out.println("Posizione "+i+" numero: "+number);
        }
    }
}