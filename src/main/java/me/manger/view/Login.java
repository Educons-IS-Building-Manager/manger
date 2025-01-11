
package me.manger.view;


public class Login extends javax.swing.JFrame {
    
    String korisnickoIme = "Admin";
    String lozinka = "admin123";


    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfKorisnickoIme = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pfLozinka = new javax.swing.JPasswordField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jmain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(850, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfKorisnickoIme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfKorisnickoIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKorisnickoImeActionPerformed(evt);
            }
        });
        getContentPane().add(tfKorisnickoIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 220, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Korisnicko Ime");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 115, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Lozinka");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 101, -1));

        pfLozinka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfLozinkaActionPerformed(evt);
            }
        });
        getContentPane().add(pfLozinka, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 220, 40));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jmain.setIcon(new javax.swing.ImageIcon("C:\\Users\\Relja\\Downloads\\Login.jpg")); // NOI18N
        jmain.setText("jLabel3");
        getContentPane().add(jmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfKorisnickoImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKorisnickoImeActionPerformed
        
    }//GEN-LAST:event_tfKorisnickoImeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String inputKorisnickoIme = tfKorisnickoIme.getText();
        String inputLozinka = pfLozinka.getText();
        
        if(!inputKorisnickoIme.equals(korisnickoIme))return;
        if(!inputLozinka.equals(lozinka))return;
        
        LoginProzor noviProzor = new LoginProzor();
        noviProzor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pfLozinkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfLozinkaActionPerformed
        
    }//GEN-LAST:event_pfLozinkaActionPerformed


    public static void main(String args[]) {
        Login noviProzor = new Login();
        noviProzor.setVisible(true);
        noviProzor.setLocationRelativeTo(null);
        noviProzor.setResizable(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jmain;
    private javax.swing.JPasswordField pfLozinka;
    private javax.swing.JTextField tfKorisnickoIme;
    // End of variables declaration//GEN-END:variables
}
