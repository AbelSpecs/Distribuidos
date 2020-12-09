package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Omar David
 */
public interface IServidor extends Remote{
    
    public List<Libro> getTitle(String titulo) throws RemoteException;
    
    public List<Libro> getAuthor(String autor) throws RemoteException;
    
    public Libro getLibro() throws RemoteException;
}
