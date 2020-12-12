package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMiddlewareZ39 extends Remote{
    
    public List<Libro> getTitle(String titulo) throws RemoteException;
    
    public List<Libro> getAuthor(String autor) throws RemoteException;
    
    public List<Libro> getLibros() throws RemoteException;
}
