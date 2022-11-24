/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monitorobserver;

import static java.lang.Thread.sleep;

/**
 *
 * @author darat
 */
public class Consumidor extends Thread implements MonitorObserver {

    private ClasesSincronizadas buff;
    private int n;
    private int sleep;

    public Consumidor(ClasesSincronizadas b, int n, int s) {
        //el monitor
        this.buff = b;
        //cuantos caracteres debe consumir
        this.n = n;
        //cuanto tiempo dormir entre carácter y carácter
        this.sleep = s;
    }

    @Override
    public void actualizar() {
        System.out.println("Estado del consumidor cambio");
    }

    @Override
    public void sacar() {
        //run();
        System.out.println("Estado del consumidor cambio");
    }

    @Override
    public void poner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run(){
        try {
            char c;
            for (int i = 0; i < n; i++) {
                c = buff.sacar();
                System.out.println("Saque:  " + c);
                sleep((int) (1 * sleep));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
