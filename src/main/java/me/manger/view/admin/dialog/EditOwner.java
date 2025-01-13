package me.manger.view.admin.dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import me.manger.model.Database;
import me.manger.model.Notification;
import me.manger.model.user.Owner;
import me.manger.view.admin.AdminFrame;

public class EditOwner extends javax.swing.JFrame {

    // 0 - add
    // 1 - edit
    int opcode;
    AdminFrame frame;
    JTable ownersTable;
    Owner owner;
    
    public EditOwner(int opcode, JTable ownersTable, AdminFrame frame) {
        initComponents();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.opcode = opcode;
        this.ownersTable = ownersTable;
        this.frame = frame;
        if(opcode == 1) {
            owner = searchOwnerInList((String) ownersTable.getValueAt(ownersTable.getSelectedRow(), 3), Database.getOwners());
            firstName.setText(owner.getFirstName());
            lastName.setText(owner.getLastName());
            email.setText(owner.getEmail());
            phone.setText(owner.getPhone());
            password.setText(owner.getPassword());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stanar [Editor]");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Korisnik");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Ime:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Prezime:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Telefon:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Password:");

        firstName.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lastName.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        email.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        phone.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        password.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jButton1.setText("Poništi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel(evt);
            }
        });

        jButton2.setText("Podnesi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lastName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1)))
                .addGap(19, 55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel
        this.setVisible(false);
    }//GEN-LAST:event_cancel

    private void submit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit
        if(firstName.getText().isBlank()) return;
        if(lastName.getText().isBlank()) return;
        if(email.getText().isBlank()) return;
        if(phone.getText().isBlank()) return;
        if(password.getPassword().length == 0) return;
        if(opcode == 0) {
            Owner owner = new Owner(firstName.getText(), lastName.getText(), email.getText(), phone.getText(),
                    firstName.getText().toLowerCase() + "." + lastName.getText().toLowerCase() + "." + ((new Random()).nextInt(99) + 1), String.valueOf(password.getPassword()),
                    new ArrayList<>(), new ArrayList<>());
            Database.getOwners().add(owner);
            Database.getLedger().addEntry("Korisnik " + owner.getUsername() + " je dodat");
            
            frame.refreshLedger();
            frame.refreshOwners();
            frame.populateTable();
            frame.populateCombo();
            this.setVisible(false);
        }
        if(opcode == 1) {
            Owner owner = searchOwnerInList((String) ownersTable.getValueAt(ownersTable.getSelectedRow(), 3), Database.getOwners());
            owner.setFirstName(firstName.getText());
            owner.setLastName(lastName.getText());
            owner.setEmail(email.getText());
            owner.setPhone(phone.getText());
            owner.setPassword(String.valueOf(password.getPassword()));
            Database.getLedger().addEntry("Korisnik " + owner.getUsername() + " je izmenjen");
            
            frame.refreshLedger();
            frame.refreshOwners();
            frame.populateTable();
            frame.populateCombo();
            this.setVisible(false);
        }
    }//GEN-LAST:event_submit

    private Owner searchOwnerInList(String username, List<Owner> list) {
        for(Owner temp : list) {
            if(temp.getUsername().equals(username)) {
                return temp;
            }
        }
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lastName;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}
