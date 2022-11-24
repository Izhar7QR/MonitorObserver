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
public class Productor extends Thread implements MonitorObserver {

    private ClasesSincronizadas buff;
    private int n;
    private int sleep;
    
    public Productor(ClasesSincronizadas b, int n,int s){
        //el monitor
        this.buff = b;
        //cuantos caracteres debe producir
        this.n = n;
        //cuanto tiempo dormir entre carácter y carácter
        this.sleep = s;
    }
    
    @Override
    public void actualizar() {
        System.out.println("Estado del productor cambio");
    }

    @Override
    public void poner() {
        //run();
    }

    @Override
    public void sacar() {

    }

    @Override
    public void run(){
        try{
            char c;
            
            for(int i=0; i<=n; i++){
                c = (char)('A'+i);
                buff.poner(c);
                System.out.println("Produje "+c);
                sleep((int)(Math.random()*sleep));
            }
        }catch(Exception ex){
        ex.printStackTrace();
        throw new RuntimeException(ex);
        }
    }
    public void produce(ClasesSincronizadas clases){
        if(clases.getEstado() != null){
            AlarmaProductorConsumidor a = new AlarmaProductorConsumidor();
            a.notificaObservadores();
        }
    }
}
