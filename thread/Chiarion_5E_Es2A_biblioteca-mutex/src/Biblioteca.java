public class Biblioteca{
    private int numPostazioni;

    public Biblioteca(int postazioni){
        this.numPostazioni = postazioni;
    }

    public int getPosti(){
        return this.numPostazioni;
    }

    public synchronized void entra(){
        while(this.numPostazioni==0){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        this.numPostazioni--;
    }

    public synchronized void esci(){
        this.numPostazioni++;
        notifyAll();
    }
}