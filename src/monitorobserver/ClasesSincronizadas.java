/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monitorobserver;

/**
 *
 * @author darat
 */
public class ClasesSincronizadas {

    private char[] buff = null;
    private int tope = 0;
    private boolean lleno = false;
    private boolean vacio = true;
    private String estado;

    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public ClasesSincronizadas(int capacidad) {
        buff = new char[capacidad];
    }

    //metodos de sincronización
    public synchronized void poner(char c) throws Exception {
        //mientras el buffer este lleno "me bloqueo" para darle la posibilidad al consumidor de mconsumir algún caracter

        while (lleno) {
            wait();
        }
        //sección crítica 
        //uso del recurso compartido---array de caracteres
        buff[++tope] = c;
        vacio = false;
        lleno = tope >= buff.length;
        notifyAll();
    }

    public synchronized char sacar() throws Exception {
        //mientras el buffer este vacío "me bloqueo" para darle la oportunidad al productor de producir algún carácter
        while (vacio) {
            wait();
        }
        //sección crítica 
        char c = buff[--tope];
        lleno = false;
        vacio = tope <= 0;

        notifyAll();
        return c;
    }
}
