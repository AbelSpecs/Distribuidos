package cliente;

import common.IMiddlewareZ39;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jdk.nashorn.tools.ShellFunctions.input;
import common.IServidorB;
import pantalla.BibliotecaB;


public class ClienteB {
    
    private static IServidorB servidor;
    private static IMiddlewareZ39 middleware;    
    private static List<Libro> catalogo;
    
    public static String ip = "127.0.0.1";
    
    public static int port = 8000;
    public static String path = "Buscar";
    
    public static int portZ39 = 8001;
    public static String pathZ39 = "Get";

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, Exception {
        //menu();
        //catalogo.forEach((libro) -> System.out.println(libro.getAuthor() + " | " + libro.getTitle()));
    }
    
    public static void menu() throws NotBoundException, MalformedURLException, RemoteException, IOException{
        Scanner scanner = new Scanner(System.in);
        int option = 10;
        while(option != 0){
            System.out.println("Bienvenido! con que bilbioteca desea interactuar?");
            System.out.println("1)Biblioteca Local");
            System.out.println("2)Biblioteca Externa");
            System.out.println("0)Salir");
            option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    ipServer();
                    servidor = (IServidorB) Naming.lookup("rmi://" + ip + ":" + port + "/" + path);
                    biblioLocal();
                    break;
                case 2:
                    ipServer();
                    middleware = (IMiddlewareZ39) Naming.lookup("rmi://" + ip + ":" + portZ39 + "/" + pathZ39);                    
                    biblioRemota();                 
                    break;                  
            }  
        }
    }
    
    public static void biblioLocal() throws RemoteException, IOException{
        Scanner scanner = new Scanner(System.in);
        String in = "";
        int option = 10;
        while(option != 0){
            System.out.println("Que desea hacer?");
            System.out.println("1)Pedir Libros por autor");
            System.out.println("2)Pedir Libros por titulo");
            System.out.println("3)Traer Catalogo");
            System.out.println("0)Salir");
            option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    System.out.println("Ingrese el autor");
                    in = scanner.nextLine();
                    catalogo = servidor.buscarAutor(in);
                    break;
                case 2:
                    System.out.println("Ingrese el Titulo");   
                    in = scanner.nextLine();
                    catalogo = servidor.buscarLibro(in);                  
                    break;      
                case 3:   
                    catalogo = servidor.getLibros();                    
                    break;     
            }
        }        
    }
    
    public static void biblioRemota() throws RemoteException{
        Scanner scanner = new Scanner(System.in);
        String in = "";
        int option = 10;
        while(option != 0){
            System.out.println("Que desea hacer?");
            System.out.println("1)Solicitar Libros por autor");
            System.out.println("2)Solicitar Libros por titulo");
            System.out.println("3)Traer Catalogo");
            System.out.println("0)Salir");
            option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    System.out.println("Ingrese el autor");
                    in = scanner.nextLine();
                    catalogo = middleware.getAuthor(in);                 
                    break;
                case 2:
                    System.out.println("Ingrese el Titulo");   
                    in = scanner.nextLine();
                    catalogo = middleware.getTitle(in);                  
                    break;      
                case 3:   
                    catalogo = middleware.getLibros();                    
                    break;     
            }
        }        
    }  
    
    public static void ipServer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ip de la biblioteca");
        ip = scanner.next();      
        while(!ipValida(ip)){
            System.out.println("Ingrese una ip valida");
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
