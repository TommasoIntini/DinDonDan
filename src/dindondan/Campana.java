/**
 * @author Intini Tommaso
 * @version 1.0
 */
package dindondan;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Tommaso
 */
/**
 * La classe serve per gestire le campane, collabora con la classe Thread
 */
public class Campana extends Thread {

    private String suono;
    /* Suono che emette la determinata campana*/
    private Semaphore attuale;
    private Semaphore successivo;

    private datiCondivisi ptrDatiC;

    //boolean yeld e daly attributi e costyruttor classi
    /**
     * @brief Costruttore della campana
     *
     * Costruttore della campana passando solo il suono che emette
     * @param suono suono che emette la campana
     */
    public Campana(String suono) {
        this.suono = suono;
    }


    public Campana(String suono, datiCondivisi datiC,Semaphore attuale,Semaphore successivo) {
        this.suono = suono;
        this.attuale = attuale;
        this.successivo = successivo;
        ptrDatiC = datiC;
    }

    /**
     * @brief il metodo fa partire l'esecuzione dei thread
     *
     * Il metodo fa partire l'esecuzione dei thread, inoltre controlla il valore
     * degli attributi delay e precedenza, per capire se eseguire lo yield o lo
     * sleep
     */
    public void run() { 
        try {
            while (true) {
                //Suono                         
                if (suono.equals("Din") || suono.equals("din")) {  
                    attuale.acquire();
                    ptrDatiC.incDin();
                    System.out.println(suono);
                    successivo.release();
                }
                if (suono.equals("Don") || suono.equals("don")) {   
                    attuale.acquire();
                    ptrDatiC.incDon();  
                    System.out.println(suono);
                    successivo.release();
                }
                if (suono.equals("Dan") || suono.equals("dan")) //if per delayù
                {              
                    attuale.acquire();
                    ptrDatiC.incDan();    
                    System.out.println(suono);
                    successivo.release();
                }

                if (Thread.interrupted() == true) {
                    break;
                }
                //Thread.sleep random time
                //if per yeld
                //Thread.yelds                
        
            }
            //Se c'e sleep
        } catch (InterruptedException e) {

            System.out.println(e);
        }
    }
    
}
