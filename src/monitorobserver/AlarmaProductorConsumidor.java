/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monitorobserver;

import java.util.ArrayList;

/**
 *
 * @author darat
 */
public class AlarmaProductorConsumidor implements Sujeto{

    private static ArrayList<MonitorObserver> observadores = 
            new ArrayList<MonitorObserver>();
    
    @Override
    public void produce(MonitorObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void consume(MonitorObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificaObservadores() {
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).actualizar();
        }
    }
    
}
