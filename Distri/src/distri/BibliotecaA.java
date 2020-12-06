package distri;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.IServidor;

/**
 *
 * @author Omar David
 */
public class BibliotecaA extends javax.swing.JFrame {

    IServidor servidor;
    
    /**
     * Creates new form BibliotecaA
     */
    public BibliotecaA() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Biblioteca A");
        try {	
            servidor = (IServidor) Naming.lookup("rmi://127.0.0.1:1234/objetoHola");
        } catch (Exception e) {	
         System.out.println(e.getMessage()); 
         }
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
        listLibros = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        rbtnTitle = new javax.swing.JRadioButton();
        rbtnAuthor = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        texLibro = new javax.swing.JTextArea();
        rbtnBiblioB = new javax.swing.JRadioButton();
        rbtnBiblioC = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoA.png"))); // NOI18N
        lblLogo.setText("Biblioteca A");
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 60));
        jPanel1.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 160, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 60, 50));

        listLibros.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
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
        jPanel1.add(rbtnTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        buttonGroup1.add(rbtnAuthor);
        rbtnAuthor.setText("Autor");
        jPanel1.add(rbtnAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        texLibro.setColumns(20);
        texLibro.setRows(5);
        jScrollPane2.setViewportView(texLibro);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 400, 250));

        buttonGroup2.add(rbtnBiblioB);
        rbtnBiblioB.setText("Biblioteca B");
        jPanel1.add(rbtnBiblioB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        buttonGroup2.add(rbtnBiblioC);
        rbtnBiblioC.setText("Biblioteca C");
        jPanel1.add(rbtnBiblioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Buscar: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 36, 60, 20));

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

        try {
            if(rbtnTitle.isSelected()){
                System.out.println(servidor.getTilte());
            }else if (rbtnAuthor.isSelected()) {
                System.out.println(servidor.getAuthor());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(BibliotecaA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listLibros;
    private javax.swing.JRadioButton rbtnAuthor;
    private javax.swing.JRadioButton rbtnBiblioB;
    private javax.swing.JRadioButton rbtnBiblioC;
    private javax.swing.JRadioButton rbtnTitle;
    private javax.swing.JTextArea texLibro;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
