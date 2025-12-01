import static java.lang.Thread.*;

public class Lettore implements Runnable{
    /* define attributes */
    private Biblioteca biblioteca;
    private String nome;

    public Lettore(Biblioteca biblioteca, String nome){
        this.biblioteca = biblioteca;
        this.nome = nome;
    }

    /* equals per confrontare se due lettori
    * sono uguali partendo dal nome */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Lettore))
            return false;

        Lettore altroLettore = (Lettore)o;
        return this.nome.equals(altroLettore.nome);
    }

    /* running method for thread */
    @Override
    public void run(){
        try{
            sleep((int)(Math.random()*20000));
        }catch(InterruptedException e){}

        System.out.println(this.nome + " vuole entrare in biblioteca");
        /* entra nella biblioteca e segnala */
        synchronized (this.biblioteca){
            this.biblioteca.entra();
            System.out.println(this.nome + " è entrato in biblioteca\nPosti liberi: "+this.biblioteca.getPosti());
        }

        try{
            sleep((int)(Math.random()*10000)); // attesa per un massimo di 10 secondi
        }catch(InterruptedException e){}

        /* esce dalla biblioteca e lo segnala */
        /* entra nella biblioteca e segnala */
        synchronized (this.biblioteca){
            this.biblioteca.esci();
            System.out.println(this.nome + " è uscito dalla biblioteca\nPosti liberi: "+this.biblioteca.getPosti());
        }
    }
}
