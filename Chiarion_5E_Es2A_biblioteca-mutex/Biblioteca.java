public class Biblioteca(){
	private int numPostazioni;
	
	public Biblioteca(int postazioni){
		this.numPostazioni = postazioni;
	}

	public synchronized void entra(){
		sleep((int)(Math.random()*20000));
		while(this.numPostazioni==0){
			try{
				wait();
			}catch(
		}
	}
}