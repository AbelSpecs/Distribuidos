/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Omar David
 */
public interface IServidor extends Remote{
    
    public String saludo() throws RemoteException;
    
    public String getTilte() throws RemoteException;
    
    public String getAuthor() throws RemoteException;
    
}
