package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServidorA extends Remote{
    
    public List<Libro> PedirLibro(String titulo) throws RemoteException;
    
    public List<Libro> PedirAutor(String autor) throws RemoteException;
    
    public List<Libro> getLibros() throws RemoteException;
}
