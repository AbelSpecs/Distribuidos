package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import common.Libro;
import sun.rmi.server.UnicastRef2;
import java.util.List;
import common.IServidorA;

public class ServidorA implements IServidorA{
    
    public String title;
    public String author;
    public List<Libro> catalog = new ArrayList<>();
    
    public void Populate(List<Libro> books){
        this.catalog.addAll((books));
    }

    @Override
    public List<Libro> PedirLibro(String titulo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Libro> PedirAutor(String autor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        return this.catalog;
    }

}
