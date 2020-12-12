package cliente;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import common.Libro;
import java.io.IOException;
import java.util.Scanner;
import common.IServidorA;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClienteA {
    
    private static IServidorA servidor;
    private static List<Libro> catalogo;
    
    public static String ip = "127.0.0.1";
    public static int port = 8000;
    public static String path = "Pedir";

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, Exception {
        menu();
        //Registry registry = LocateRegistry.getRegistry(); 
        //Registry registry = LocateRegistry.createRegistry(5678);
        //servidor = (IServidor)registry.lookup("Servant");
        System.out.println(catalogo.get(0).getTitle() +" | "+ catalogo.get(0).getAuthor());
        System.out.println(catalogo.get(1).getTitle() +" | "+ catalogo.get(1).getAuthor());
        System.in.read();
    }
    
    public static void menu() throws NotBoundException, MalformedURLException, RemoteException, IOException{
        Scanner scanner = new Scanner(System.in);
        int option = 10;
        while(option != 0){
            System.out.println("Bienvenido! que bilbioteca desea interactuar?");
            System.out.println("1)Biblioteca A");
            System.out.println("2)Biblioteca B");
            System.out.println("3)Biblioteca C");
            System.out.println("0)Salir");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    ipServer();
                    servidor = (IServidorA) Naming.lookup("rmi://" + ip + ":" + port + "/" + path);
                    biblioA();
                    option = 0;
                    break;
                case 2:
                    ipServer();
                    biblioB();
                    option = 0;                    
                    break;   
                case 3:
                    ipServer();                   
                    biblioC();
                    option = 0;                    
                    break;                   
            }  
        }
    }
    
    public static void biblioA() throws RemoteException{
        Scanner scanner = new Scanner(System.in);
        String in = "";
        int option = 10;
        while(option != 0){
            System.out.println("Que desea hacer?");
            System.out.println("1)Pedir Libros por autor");
            System.out.println("2)Pedir Libros por titulo");
            System.out.println("3)Traer Catalogo");
            System.out.println("0)Salir");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("Ingrese el autor");
                    in = scanner.nextLine();
                    servidor.PedirAutor(in);
                    option = 0;                    
                    break;
                case 2:
                    System.out.println("Ingrese el Titulo");   
                    in = scanner.nextLine();
                    servidor.PedirLibro(in);
                    option = 0;                    
                    break;      
                case 3:   
                    catalogo = servidor.getLibros();
                    option = 0;                    
                    break;     
            }  
        }        
    }
    
    public static void biblioB(){
        
    }   
    
    public static void biblioC(){
        
    }
    
    public static void ipServer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ip de la biblioteca remota");
        ip = scanner.next();      
        while(!ipValida(ip)){
            System.out.println("Ingrese la ip de la biblioteca remota correctamente");
            ip = scanner.next();            
        }
  
    }
    
    public static boolean ipValida(String ip) 
    { 
        String zeroTo255 
            = "(\\d{1,2}|(0|1)\\"
              + "d{2}|2[0-4]\\d|25[0-5])"; 
        String regex 
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255; 
        Pattern p = Pattern.compile(regex); 
        if (ip == null) { 
            return false; 
        } 
        Matcher m = p.matcher(ip); 
        return m.matches(); 
    } 
    
} 
