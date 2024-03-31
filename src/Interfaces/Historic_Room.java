/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Main.Global;
import Nodes.Node_Client;
import Nodes.Node_Room;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pjroj
 */
public class Historic_Room extends javax.swing.JFrame {
    DefaultTableModel m1 = new DefaultTableModel();
    /**
     * Creates new form Menu
     */
    public Historic_Room() {
        initComponents();
        setTitle("Buscar Historial");
        setResizable(false);
        this.setLocationRelativeTo(null);
        
        //los atributos de las columnas
        String ids[] = {"Cédula","Nombre","Apellido","Email","Género"};
        
        //se setteat los atributos a la tabla
        m1.setColumnIdentifiers(ids);
        jTable1.setModel(m1);
        
        //se define el tamaño de las celdas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(160);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        //jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        roomNumber = new javax.swing.JTextField();
        search_history_room_btn = new javax.swing.JButton();
        JLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back_to_menu_btn = new javax.swing.JButton();
        numRoom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        menu.setBackground(new java.awt.Color(0, 51, 102));
        menu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        menu.setText("Ir al menú");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1050, 518));
        setMixingCutoutShape(null);
        setPreferredSize(new java.awt.Dimension(1050, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 75, -1, -1));

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel4.setFont(new java.awt.Font("Kubo Sans", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(75, 25, 0));
        jLabel4.setText("HISTORIAL DE HABITACIÓN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        JLabel7.setFont(new java.awt.Font("Kubo Sans", 1, 14)); // NOI18N
        JLabel7.setForeground(new java.awt.Color(75, 25, 0));
        JLabel7.setText("Número de habitación :");
        getContentPane().add(JLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, 20));

        roomNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberActionPerformed(evt);
            }
        });
        getContentPane().add(roomNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 210, -1));

        search_history_room_btn.setBackground(new java.awt.Color(75, 25, 0));
        search_history_room_btn.setFont(new java.awt.Font("Kubo Sans", 1, 14)); // NOI18N
        search_history_room_btn.setForeground(new java.awt.Color(255, 248, 231));
        search_history_room_btn.setText("Buscar");
        search_history_room_btn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search_history_room_btn.setOpaque(true);
        search_history_room_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_history_room_btnActionPerformed(evt);
            }
        });
        getContentPane().add(search_history_room_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 100, 30));

        JLabel5.setFont(new java.awt.Font("Kubo Sans", 1, 18)); // NOI18N
        JLabel5.setForeground(new java.awt.Color(75, 25, 0));
        JLabel5.setText("Clientes que se hospedaron anteriormente en la habitación");
        getContentPane().add(JLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 990, 180));

        back_to_menu_btn.setBackground(new java.awt.Color(75, 25, 0));
        back_to_menu_btn.setFont(new java.awt.Font("Kubo Sans", 1, 14)); // NOI18N
        back_to_menu_btn.setForeground(new java.awt.Color(255, 248, 231));
        back_to_menu_btn.setText("Volver al menú");
        back_to_menu_btn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back_to_menu_btn.setOpaque(true);
        back_to_menu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_menu_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_to_menu_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 130, 30));

        numRoom.setFont(new java.awt.Font("Kubo Sans", 1, 14)); // NOI18N
        numRoom.setForeground(new java.awt.Color(75, 25, 0));
        numRoom.setText("...");
        getContentPane().add(numRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 50, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Window_History_Room.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_history_room_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_history_room_btnActionPerformed
        try {
             //Se reinicia la tabla de busqueda si ya se buscó anteriormente alguna reservación
            if (m1.getRowCount() != 0) {
                while(m1.getRowCount() != 0){
                    m1.removeRow(0);
                }
            }
            int num = Integer.parseInt(roomNumber.getText());
            
            if (num >= 1 && num <= 300) {
                numRoom.setText(roomNumber.getText());
                roomNumber.setText("");
            }
            
            //Se busca la habitación en el arbol de historial
            Node_Room room = Global.getRooms().search(num, Global.getRooms().getRoot());
            
            //Si existe el nodo encontrado se le busca su historial de clientes que se hospedaron 
            Node_Client aux = room.getRoom().getClientHistory().getHead();
            
            while (aux != null) {
                if(aux.getClient().getId() == null){
                    m1.addRow(new Object[]{" - ",aux.getClient().getName(),aux.getClient().getLastname(),aux.getClient().getEmail(),aux.getClient().getGender()});
                }else{
                   m1.addRow(new Object[]{aux.getClient().getId(),aux.getClient().getName(),aux.getClient().getLastname(),aux.getClient().getEmail(),aux.getClient().getGender()});
                }
                aux = aux.getNext();
            }
        } catch (Exception e) {
            numRoom.setText("...");
            JOptionPane.showMessageDialog(null, "¡No existe la habitación ingresada!");
        }
    }//GEN-LAST:event_search_history_room_btnActionPerformed

    private void back_to_menu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_menu_btnActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_to_menu_btnActionPerformed

    private void roomNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberActionPerformed

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
            java.util.logging.Logger.getLogger(Historic_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historic_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historic_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historic_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historic_Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JButton back_to_menu_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton menu;
    private javax.swing.JLabel numRoom;
    private javax.swing.JTextField roomNumber;
    private javax.swing.JButton search_history_room_btn;
    // End of variables declaration//GEN-END:variables
}
