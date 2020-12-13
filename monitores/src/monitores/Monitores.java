package monitores;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Omar David
 */
public class Monitores {

    protected ArrayList<Object> lista = new ArrayList<Object>();
        
    protected void producir(){
        int cantElementos = 0;
        
        synchronized(lista){
            Object nuevoElemento = new Object();
            
            lista.add(nuevoElemento);
            cantElementos = lista.size();
            lista.notifyAll();
        }
        System.out.println("elementos luego de la produccion: "+ cantElementos);
    }
    
    protected void consumir() {
        Object elemento = null;
        int cantElementos = 0;
        
        synchronized(lista){
            while(lista.size() == 0){
                try {
                    lista.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            
            cantElementos = lista.size() - 1;
            elemento = lista.get(cantElementos);
            lista.remove(cantElementos);
            cantElementos = lista.size();
        }
        System.out.println("elemento consumido " + elemento.toString());
        System.out.println("elementos luego de consumir: " + cantElementos);
    }
    
    public static void main(String[] args) throws IOException {
        Monitores monitor = new Monitores();
        int caracter;
        
        System.out.println("Presione p para poducir o c para consumir");
        
        while((caracter = System.in.read()) != -1){
            switch(caracter){
                case 'p': monitor.producir();
                    break;
                    
                case 'c':
                    monitor.consumir();
            }
        }
    }
    
}
