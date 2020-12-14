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
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorA implements IServidorA{
    
    public String title;
    public String author;
    public static URL path = ServidorA.class.getResource("bibliotecaA.xml");
    public List<Libro> catalog = new ArrayList<>();


    @Override
    public List<Libro> pedirLibro(String titulo) throws RemoteException {
        System.out.println("Peticion de encontrar libros por autor: " + titulo);  
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            ManejadorXML manejador = new ManejadorXML(current + "/" + "bibliotecaA.xml");
        this.catalog = manejador.buscarTitulo(titulo);
        } catch (IOException ex) {
            Logger.getLogger(ServidorA.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return this.catalog;
    }

    @Override
    public List<Libro> pedirAutor(String autor) throws RemoteException {
        System.out.println("Peticion de encontrar libros por autor: " + autor);       
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            ManejadorXML manejador = new ManejadorXML(current + "/" + "bibliotecaA.xml");
        this.catalog = manejador.buscarAuthor(autor);
        } catch (IOException ex) {
            Logger.getLogger(ServidorA.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return this.catalog;
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        System.out.println("Peticion de retornar libreria completa");
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            ManejadorXML manejador = new ManejadorXML(current + "/" + "bibliotecaA.xml");
            this.catalog = manejador.cargarXML();
        } catch (IOException ex) {
            Logger.getLogger(ServidorA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.catalog;
    }

}
