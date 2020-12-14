package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServidorB extends Remote{
    
    public List<Libro> buscarLibro(String titulo) throws RemoteException;
    
    public List<Libro> buscarAutor(String autor) throws RemoteException;
    
    public List<Libro> getLibros() throws RemoteException;
}
