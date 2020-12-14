package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import common.Libro;
import sun.rmi.server.UnicastRef2;
import java.util.List;
import java.io.File;
import java.net.URL;
import common.IServidorB;

public class ServidorB implements IServidorB{
    
    public String title;
    public String author;
    public static URL path = ServidorB.class.getResource("bibliotecaB.xml");
    public List<Libro> catalog = new ArrayList<>();


    @Override
    public List<Libro> buscarLibro(String titulo) throws RemoteException {
        System.out.println("Peticion de encontrar libros por autor: " + titulo);  
        ManejadorXML manejador = new ManejadorXML(path.getFile()); 
        this.catalog = manejador.buscarTitulo(titulo);
        return this.catalog;
    }

    @Override
    public List<Libro> buscarAutor(String autor) throws RemoteException {
        System.out.println("Peticion de encontrar libros por autor: " + autor);  
        ManejadorXML manejador = new ManejadorXML(path.getFile()); 
        this.catalog = manejador.buscarAuthor(autor);
        return this.catalog;
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        System.out.println("Peticion de retornar libreria completa");  
        ManejadorXML manejador = new ManejadorXML(path.getFile()); 
        this.catalog = manejador.cargarXML();
        return this.catalog;
    }

}
