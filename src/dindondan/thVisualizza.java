/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

/**
 *
 * @author intini_tommaso
 */
public class thVisualizza extends Thread{
    datiCondivisi ptrDatiC;
    
    public thVisualizza(datiCondivisi ptrDati)
    {
        this.ptrDatiC = ptrDati;
    }
    public void run()
    {
        System.out.println("Si son verificati: "+ptrDatiC.getnDin()+" Din");
        System.out.println("Si son verificati: "+ptrDatiC.getnDon()+" Don");
        System.out.println("Si son verificati: "+ptrDatiC.getnDan()+" Dan");
    }
}
