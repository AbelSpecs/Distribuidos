package pantalla;

import static cliente.ClienteA.biblioLocal;
import static cliente.ClienteA.biblioRemota;
import static cliente.ClienteA.ip;
import static cliente.ClienteA.ipServer;
import static cliente.ClienteA.ipValida;
import static cliente.ClienteA.path;
import static cliente.ClienteA.pathZ39;
import static cliente.ClienteA.port;
import static cliente.ClienteA.portZ39;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import common.IServidorA;
import common.IMiddlewareZ39;
import common.Libro;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author Omar David
 */
public class BibliotecaA extends javax.swing.JFrame {

    private static IServidorA servidor;
    private static IMiddlewareZ39 middleware;    
    private static List<Libro> catalogo;
    
    public static String ip = "127.0.0.1";
    
    public static int port = 8000;
    public static String path = "Pedir";
    
    public static int portZ39 = 8001;
    public static String pathZ39 = "Get";
    
    /**
     * Creates new form BibliotecaA
     */
    public BibliotecaA() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Biblioteca A");
//        try {	
//            servidor = (IServidorA) Naming.lookup("rmi://" + ip + ":" + port + "/" + path);
//        } catch (Exception e) {	
//         System.out.println(e.getMessage()); 
//         }
    }
    
//    public static void menu() throws NotBoundException, MalformedURLException, RemoteException, IOException{
//        Scanner scanner = new Scanner(System.in);
//        int option = 10;
//        while(option != 0){
//            System.out.println("Bienvenido! con que bilbioteca desea interactuar?");
//            System.out.println("1)Biblioteca Local");
//            System.out.println("2)Biblioteca Externa");
//            System.out.println("0)Salir");
//            option = Integer.parseInt(scanner.nextLine());
//            switch(option){
//                case 1:
//                    ipServer();
//                    servidor = (IServidorA) Naming.lookup("rmi://" + ip + ":" + port + "/" + path);
//                    //biblioLocal();
//                    break;
//                case 2:
//                    ipServer();
//                    middleware = (IMiddlewareZ39) Naming.lookup("rmi://" + ip + ":" + portZ39 + "/" + pathZ39);                    
//                    biblioRemota();                 
//                    break;                  
//            }  
//        }
//    }
    
    
    
    public static List<Libro> biblioLocal(int opcion, String cadena) throws RemoteException, IOException{
        Scanner scanner = new Scanner(System.in);
        String in = cadena;
        int option = opcion;
//        while(option != 0){
//            System.out.println("Que desea hacer?");
//            System.out.println("1)Pedir Libros por autor");
//            System.out.println("2)Pedir Libros por titulo");
//            System.out.println("3)Traer Catalogo");
//            System.out.println("0)Salir");
//              option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
//                    System.out.println("Ingrese el autor");
//                    in = scanner.nextLine();
                    catalogo = servidor.pedirAutor(in);
                    break;
                case 2:
//                    System.out.println("Ingrese el Titulo");   
//                    in = scanner.nextLine();
                    catalogo = servidor.pedirLibro(in);                  
                    break;      
                case 3:   
                    catalogo = servidor.getLibros();
                    System.out.println(catalogo.get(0).getAuthor());
                    
                    break;     
            }
            return catalogo;
        //}        
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLibros = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        rbtnTitle = new javax.swing.JRadioButton();
        rbtnLibros = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        texLibro = new javax.swing.JTextArea();
        rbtnBiblioA = new javax.swing.JRadioButton();
        rbtnBiblioC = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscador1 = new javax.swing.JTextField();
        rbtnBiblioB = new javax.swing.JRadioButton();
        rbtnAuthor1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoA.png"))); // NOI18N
        lblLogo.setText("Biblioteca A");
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 60));

        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 160, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 60, 40));

        jScrollPane1.setViewportView(listLibros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 330));

        jLabel1.setText("Título :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, -1));
        jPanel1.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 210, 20));

        jLabel3.setText("Autor :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 70, -1));
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 210, 20));

        buttonGroup1.add(rbtnTitle);
        rbtnTitle.setText("Título");
        jPanel1.add(rbtnTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        buttonGroup1.add(rbtnLibros);
        rbtnLibros.setText("Libros");
        jPanel1.add(rbtnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        texLibro.setColumns(20);
        texLibro.setRows(5);
        jScrollPane2.setViewportView(texLibro);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 400, 250));

        buttonGroup2.add(rbtnBiblioA);
        rbtnBiblioA.setText("Biblioteca A");
        rbtnBiblioA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnBiblioAActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnBiblioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        buttonGroup2.add(rbtnBiblioC);
        rbtnBiblioC.setText("Biblioteca C");
        jPanel1.add(rbtnBiblioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Ip:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 60, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Buscar: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 60, 20));

        txtBuscador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 160, 30));

        buttonGroup2.add(rbtnBiblioB);
        rbtnBiblioB.setText("Biblioteca B");
        jPanel1.add(rbtnBiblioB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        buttonGroup1.add(rbtnAuthor1);
        rbtnAuthor1.setText("Autor");
        jPanel1.add(rbtnAuthor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ip = txtBuscador.getText();
        String cadena = txtBuscador1.getText();
        List<Libro> libro;
        if(rbtnBiblioA.isSelected()){
            try {
                servidor = (IServidorA) Naming.lookup("rmi://" + ip + ":" + port + "/" + path);
                if(rbtnAuthor1.isSelected()){
                    biblioLocal(1,cadena);
                }
                else if(rbtnTitle.isSelected()){
                    biblioLocal(2,cadena);
                }
                else if(rbtnLibros.isSelected()){  
                    lblAutor.setText(biblioLocal(3,cadena).get(0).getAuthor());     
                }
                
            } catch (NotBoundException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            try {                    
                middleware = (IMiddlewareZ39) Naming.lookup("rmi://" + ip + ":" + portZ39 + "/" + pathZ39);
                if(rbtnAuthor1.isSelected()){
                    biblioRemota();
                }
                else if(rbtnTitle.isSelected()){
                    biblioRemota();
                }
                else if(rbtnLibros.isSelected()){
                    biblioRemota();
                }
                
                
            } catch (NotBoundException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }    
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    
    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
       
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void txtBuscador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador1ActionPerformed

    private void rbtnBiblioAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnBiblioAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnBiblioAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BibliotecaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BibliotecaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BibliotecaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BibliotecaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listLibros;
    private javax.swing.JRadioButton rbtnAuthor1;
    private javax.swing.JRadioButton rbtnBiblioA;
    private javax.swing.JRadioButton rbtnBiblioB;
    private javax.swing.JRadioButton rbtnBiblioC;
    private javax.swing.JRadioButton rbtnLibros;
    private javax.swing.JRadioButton rbtnTitle;
    private javax.swing.JTextArea texLibro;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtBuscador1;
    // End of variables declaration//GEN-END:variables
}
