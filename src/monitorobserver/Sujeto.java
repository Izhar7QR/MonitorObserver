/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package monitorobserver;

/**
 *
 * @author darat
 */
public interface Sujeto {
    public void produce(MonitorObserver observador);
    public void consume(MonitorObserver observador);
    public void notificaObservadores();
}
