package me.manger.view;

import java.util.ArrayList;
import me.manger.view.admin.AdminFrame;
import me.manger.model.Database;
import me.manger.model.Options;
import me.manger.model.user.Admin;
import me.manger.model.user.Owner;
import me.manger.model.user.President;
import me.manger.view.owner.OwnerFrame;
import me.manger.view.president.PresidentFrame;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        incorrectPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(600, 400));

        jLabel1.setText("Username");

        usernameField.setToolTipText("Username...");

        jLabel2.setText("Password");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login(evt);
            }
        });

        incorrectPassword.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(incorrectPassword)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(incorrectPassword)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login
        Admin admin = Database.getAdmin();
        if(admin.getUsername().equals(usernameField.getText())) {
            if(!admin.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
                incorrectPassword.setText("Incorrect password");
                return;
            }
            AdminFrame frame = new AdminFrame();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            this.setVisible(false);
            return;
        }
        President president = Database.getPresident();
        if(president.getUsername().equals(usernameField.getText())) {
            if(!president.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
                incorrectPassword.setText("Incorrect password");
                return;
            }
            PresidentFrame frame = new PresidentFrame();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            this.setVisible(false);
            return;
        }
        ArrayList<Owner> owners = Database.getOwners();
        for(Owner owner : owners) {
            if(usernameField.getText().equals(owner.getUsername())) {
                if(!String.valueOf(passwordField.getPassword()).equals(owner.getPassword())) {
                    incorrectPassword.setText("Incorrect password");
                    return;
                }
                Options.loggedIn = owner;
                OwnerFrame frame = new OwnerFrame();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                this.setVisible(false);
            }
        }
        incorrectPassword.setText("Incorrect username");
    }//GEN-LAST:event_login

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel incorrectPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
