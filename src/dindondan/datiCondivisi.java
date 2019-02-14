/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

/**
 *
 * @author Tommaso
 *
 */
/**
 *
 * La classe ha il compito di permettere la cooperazione tra i vari thread
 */
public class datiCondivisi {

    private int nDin;
    /**
     * incrementa il numero di Din
     */
    private int nDon;
    /**
     * incrementa il numero di Don
     */
    private int nDan;

    /**
     * incrementa il numero di Dan
     */
    
    private Semaforo semDin = null;
    private Semaforo semDon = null;
    private Semaforo semDan = null;
    /**
     * @brief costruttore dell'oggetto datiCondivisi
     *
     * Costruttore che inizializza i valori degli attributi a 0
     */
    public datiCondivisi() {
        nDin = 0;
        nDan = 0;
        nDon = 0;
        
        semDin = new Semaforo(1);
        semDon = new Semaforo(1);
        semDan = new Semaforo(1);
    }

    /**
     * @brief restituisce il valore dell'attributo nDin
     */
    public int getnDin() {
        return nDin;
    }

    /**
     * @brief restituisce il valore dell'attributo nDon
     */
    public int getnDon() {
        return nDon;
    }

    /**
     * @brief restituisce il valore dell'attributo nDan
     */
    public int getnDan() {
        return nDan;
    }

    /**
     * @brief incrementa il valore dell'attributo nDin
     */
    public void incDin() {
        nDin++;
    }

    /**
     * @brief incrementa il valore dell'attributo nDan
     */
    public void incDan() {
        nDan++;
    }

    /**
     * @brief incrementa il valore dell'attributo nDon
     */
    public void incDon() {
        nDon++;
    }

    
    /**
     * @brief il metodo restituisce la campana che ha suonapo più volte
     * 
     * Il metodo ha il compito di confrontare i valori degli attributi e 
     * determinare quello con il valore maggiore.
     * Inoltre restituisce il nome della campana che ha suonato più volte.
     * 
     * @return Max stringa contenente il nome della campana che ha suonato più volte.
     */
    public String getMaxSound() {
        String Max = " ";
        if (nDin > nDan && nDin > nDon) {
            Max = "Din";
        } else if (nDan > nDin && nDan > nDon) {
            Max = "Dan";
        } else if (nDon > nDan && nDon > nDin) {
            Max = "Don";
        }

        return Max;
    }
    
    public void waitDin()
    {
        semDin.Wait();
    }
    public void waitDon()
    {
        semDon.Wait();
    }
    public void waitDan()
    {
        semDan.Wait();
    }
    
    public void signalDin()
    {
        semDin.Signal();
    }
    public void signalDon()
    {
        semDon.Signal();
    }
    public void signalDan()
    {
        semDan.Signal();
    }
}
