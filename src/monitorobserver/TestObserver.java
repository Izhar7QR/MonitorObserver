/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monitorobserver;

/**
 *
 * @author darat
 */
public class TestObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClasesSincronizadas c = new ClasesSincronizadas(5);
        AlarmaProductorConsumidor a = new AlarmaProductorConsumidor();
        a.notificaObservadores();
        
        Productor p = new Productor(c, 5, 300);
        Consumidor con = new Consumidor(c, 5, 300);
        
        p.start();
        con.start();
        
    }
    
}
