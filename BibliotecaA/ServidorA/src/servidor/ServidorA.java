package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import common.Libro;
import sun.rmi.server.UnicastRef2;
import java.util.List;
import common.IServidorA;
import java.io.File;
import java.net.URL;

public class ServidorA implements IServidorA{
    
    public String title;
    public String author;
    public static URL path = ServidorA.class.getResource("bibliotecaA.xml");
    public List<Libro> catalog = new ArrayList<>();


    @Override
    public List<Libro> pedirLibro(String titulo) throws RemoteException {
        ManejadorXML manejador = new ManejadorXML(path.getFile()); 
        this.catalog = manejador.buscarTitulo(titulo);
        return this.catalog;
    }

    @Override
    public List<Libro> pedirAutor(String autor) throws RemoteException {
        ManejadorXML manejador = new ManejadorXML(path.getFile()); 
        this.catalog = manejador.buscarAuthor(autor);
        return this.catalog;
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        ManejadorXML manejador = new ManejadorXML(path.getFile()); 
        this.catalog = manejador.cargarXML();
        return this.catalog;
    }

}
