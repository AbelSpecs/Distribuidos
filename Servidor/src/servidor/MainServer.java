/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Omar David
 */
public class MainServer {
    
    public static void main(String[] args){
        try {	

            LocateRegistry.createRegistry(1234);
            Naming.rebind("rmi://127.0.0.1:1234/objetoHola", new Servidor());

            System.out.println("Servidor iniciado");

        } catch (Exception e) {	
            System.out.println(e.getMessage()); 
         }
    }
}
