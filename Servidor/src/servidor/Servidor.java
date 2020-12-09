/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import common.Libro;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Omar David
 */
public class Servidor extends UnicastRemoteObject implements IServidor{

    Libro libro = new Libro("Libro prueba 1", "Autor del libro1");
    
    public Servidor() throws RemoteException{
        super();
    }
    
    @Override
    public String saludo() throws RemoteException {
        return "Hola, prueba de codigo RMI";
    }

    @Override
    public String getTilte() throws RemoteException {
        return libro.getTitle();
    }

    @Override
    public String getAuthor() throws RemoteException {
        return libro.getAuthor();
    }
    
}
