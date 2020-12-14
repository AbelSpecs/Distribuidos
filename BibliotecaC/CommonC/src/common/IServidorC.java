package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServidorC extends Remote{
    
    public List<Libro> encontrarLibro(String titulo) throws RemoteException;
    
    public List<Libro> encontrarAutor(String autor) throws RemoteException;
    
    public List<Libro> getLibros() throws RemoteException;
}
