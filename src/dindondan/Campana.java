/**
 * @author Intini Tommaso
 * @version 1.0
 */
package dindondan;

import static java.lang.Thread.sleep;
import java.util.Random;

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
    private boolean delay;/* Booleana che dice se si deve aspettare*/
    private boolean precedenza;/* Booleana che dice se bisogna effettuare lo yield*/

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

    /**
     * @brief Costruttore della campana
     *
     * Cotruttore della campana, riceve il suono della campana se deve fare un
     * delay o lo yield
     *
     * @param suono che emette la campana
     * @param delay se deve aspettare
     * @param precedenza se deve dare precedenza
     */
    public Campana(String suono, boolean delay, boolean precedenza) {
        this.suono = suono;
        this.delay = delay;
        this.precedenza = precedenza;
    }

    public Campana(String suono, boolean delay, boolean precedenza, datiCondivisi datiC) {
        this.suono = suono;
        this.delay = delay;
        this.precedenza = precedenza;
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
                System.out.println(suono);
                if (delay) {
                    Random rd = new Random();
                    sleep(rd.nextInt(3000));
                }
                if (precedenza) {
                    yield();
                }

                if (suono.equals("Din") || suono.equals("din")) {
                    ptrDatiC.waitDin();
                    ptrDatiC.incDin();
                    ptrDatiC.signalDin();
                }
                if (suono.equals("Don") || suono.equals("don")) {
                    ptrDatiC.waitDon();
                    ptrDatiC.incDon();
                    ptrDatiC.signalDon();
                }
                if (suono.equals("Dan") || suono.equals("dan")) //if per delayù
                {
                    ptrDatiC.waitDan();
                    ptrDatiC.incDan();
                    ptrDatiC.signalDan();
                }

                if (Thread.interrupted() == true) {
                    break;
                }
                //Thread.sleep random time
                //if per yeld
                //Thread.yelds                
                {

                }
            }
            //Se c'e sleep
        } catch (InterruptedException e) {

            System.out.println(e);
        }
    }
}
