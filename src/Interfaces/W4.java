package Interfaces;


import Main.Global;
import Nodes.Node_Client;
import Nodes.Node_Reservation;
import Nodes.Node_Room;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolasplanas
 */
public class W4 extends javax.swing.JFrame {

    /**
     * Creates new form W4
     */
    public W4() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        client_id = new javax.swing.JTextField();
        accept_bttn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultCheckIn = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Murs Gothic", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHECK-IN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 380, -1));

        jLabel2.setFont(new java.awt.Font("Powerr", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ESTADO DEL CHECKEO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 310, 50));

        client_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_idActionPerformed(evt);
            }
        });
        getContentPane().add(client_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 240, 40));

        accept_bttn.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        accept_bttn.setText("ACEPTAR");
        accept_bttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accept_bttnActionPerformed(evt);
            }
        });
        getContentPane().add(accept_bttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 160, 40));

        jLabel3.setFont(new java.awt.Font("Powerr", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese la cédula del cliente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 470, 50));

        resultCheckIn.setColumns(20);
        resultCheckIn.setRows(5);
        jScrollPane1.setViewportView(resultCheckIn);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 360, 170));

        jButton1.setText("GO BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 90, -1));

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void client_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_idActionPerformed

    }//GEN-LAST:event_client_idActionPerformed

    private void accept_bttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accept_bttnActionPerformed
        
        try {
            // BUSCAMOS AL CLIENTE.
            int id = Integer.parseInt(client_id.getText());
            Node_Reservation reservation = Global.getReservations().search(id, Global.getReservations().getRoot());
            String roomType = reservation.getReservation().getRoom_type();
            //ESTABLECEMOS QUE HABITACIONES NO ESTÁN DISPONIBLES.
            Global.getClients().notAvailableRooms();
            //BUSCAMOS LA HABITACIÓN QUE ESTÉ DISPONIBLE DEPENDIENDO AL TIPO QUE DESEE EL CLIENTE.
            int numberRoomAvailable = Global.getRooms().searchRoomType(roomType, Global.getRooms().getRoot());
            Global.getRooms().search(numberRoomAvailable, Global.getRooms().getRoot()).getRoom().setAvailable(false);
            //AÑADIMOS EL CLIENTE AL REGISTRO DE ESTADO EN EL HASHTABLE.
            Global.getClients().addClientTable(reservation.getReservation().getClient(), reservation.getReservation().getArrival());
            //ASIGNAMOS LA HABITACIÓN AL CLIENTE.
            reservation.getReservation().getClient().setRoomNumber(Integer.toString(numberRoomAvailable));
            Node_Room room = Global.getRooms().search(numberRoomAvailable, Global.getRooms().getRoot());
            //AÑADIMOS EL CLIENTE AL HISTORIAL DE LA HABITACIÓN.
            room.getRoom().getClientHistory().insertBegining(new Node_Client(reservation.getReservation().getClient()));
            //EN EL ARBOL RESERVACIONES ELIMINAMOS LA RESERVACIÓN DEL CLIENTE.
            Global.getReservations().delete(id, Global.getReservations().getRoot(), null);
            resultCheckIn.setText(Global.getClients().searchClient(reservation.getReservation().getClient().getName(), reservation.getReservation().getClient().getLastname()));
            client_id.setText("");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡La reservación para ese cliente no existe!");
            }
    }//GEN-LAST:event_accept_bttnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        this.setVisible(false);
//        W w = new W();
//        w.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(W4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(W4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(W4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(W4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new W4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept_bttn;
    private javax.swing.JTextField client_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultCheckIn;
    // End of variables declaration//GEN-END:variables
}
