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
import common.IServidorC;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorC implements IServidorC{
    
    public String title;
    public String author;
    public static URL path = ServidorC.class.getResource("bibliotecaC.xml");
    public List<Libro> catalog = new ArrayList<>();


    @Override
    public List<Libro> encontrarLibro(String titulo) throws RemoteException {
        System.out.println("Peticion de encontrar libros por autor: " + titulo);  
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            ManejadorXML manejador = new ManejadorXML(current + "/" + "bibliotecaC.xml");
        this.catalog = manejador.buscarTitulo(titulo);
        } catch (IOException ex) {
            Logger.getLogger(ServidorC.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return this.catalog;
    }

    @Override
    public List<Libro> encontrarAutor(String autor) throws RemoteException {
        System.out.println("Peticion de encontrar libros por autor: " + autor);       
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            ManejadorXML manejador = new ManejadorXML(current + "/" + "bibliotecaC.xml");
        this.catalog = manejador.buscarAuthor(autor);
        } catch (IOException ex) {
            Logger.getLogger(ServidorC.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return this.catalog;
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        System.out.println("Peticion de retornar libreria completa");
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            ManejadorXML manejador = new ManejadorXML(current + "/" + "bibliotecaC.xml");
            this.catalog = manejador.cargarXML();
        } catch (IOException ex) {
            Logger.getLogger(ServidorC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.catalog;
    }

}
