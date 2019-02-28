/**
 * @author Intini Tommaso
 * @verison 1.0
 */
package dindondan;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Tommaso Main del programma
 */
/**
 * Main del programma
 */
public class DinDonDan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  //Creazione oggetto scanner
        Semaphore sDin = new Semaphore(1);
        Semaphore sDon = new Semaphore(0);
        Semaphore sDan = new Semaphore(0);
        
        
        datiCondivisi datiC = new datiCondivisi();
        
        thVisualizza view = null;
        Campana din = new Campana("Din", datiC,sDin,sDon);//Creo 3 oggetti campana
        Campana don = new Campana("Don", datiC,sDon,sDan);
        Campana dan = new Campana("Dan", datiC,sDan,sDin);//Ognuno emette un suono diverso
        // TODO code application logic here
        sc.next();
        try {
            din.start();  //Avvia i thread
            
            don.start();
            
            dan.start();

            sc.next(); //attesa input

            din.interrupt();      //Interrompo i thread
            don.interrupt();
            dan.interrupt();

            din.join(); //Aspetta che finiscano
            don.join();
            dan.join();

        } catch (InterruptedException e) {//Se si verifica un interruzione               
            System.out.println(e);
        }

        System.out.println("Si sono verificati un numero maggiore di Din Don o Dan?");  //Saluto
        
        if(sc.next().equals(datiC.getMaxSound())){
            System.out.println("Bravo, Hai indovinato!!!");
        }
        else {
            System.out.println("Vergogna, Hai sbagliato!!");
        }
        
        view = new thVisualizza(datiC);
        
        try
        {
            view.start();
            view.join(); 
        } catch (Exception e)
        {
            System.out.println("Errore nel join");
        }

               
    }

}





//Non riesco a far funzionare l'interruzione con la pressione di un pulsante
