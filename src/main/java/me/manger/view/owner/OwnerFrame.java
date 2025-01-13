package me.manger.view.owner;

import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import me.manger.Manger;
import me.manger.db.WriteFile;
import me.manger.model.Company;
import me.manger.model.Database;
import me.manger.model.Notification;
import me.manger.model.Options;
import me.manger.model.Apartment;
import me.manger.model.ledger.Entry;
import me.manger.model.user.Owner;
import me.manger.model.user.President;
import me.manger.view.owner.dialog.Complaint;

public class OwnerFrame extends javax.swing.JFrame {

    DefaultTableModel modelMain;
    DefaultTableModel modelLedger;
    DefaultTableModel modelNotif;
    
    public OwnerFrame() {
        initComponents();
        initMain();
        initLedger();
        initContact();
        initNotif();
        
        notifTable.setDefaultEditor(Object.class, null);
        ledgerTable.setDefaultEditor(Object.class, null);
        mainTable.setDefaultEditor(Object.class, null);
    }
    
    private void initNotif() {
        notifTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        notifTable.getColumnModel().getColumn(0).setPreferredWidth(220);
        notifTable.getColumnModel().getColumn(0).setMaxWidth(220);
        
        notifTable.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 18));
        notifTable.setRowHeight(30);
        
        modelNotif = (DefaultTableModel) notifTable.getModel();
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        for(Notification notif : Options.loggedIn.getNotifications()){
            modelNotif.addRow(new Object[]{dt.format(notif.getDate()), notif.getMessage()});
        }
        notifTable.changeSelection(notifTable.getRowCount() - 1, 0, false, false);
    }
    
    private void initContact() {
        President president = Database.getPresident();
        presFirst.setText(president.getFirstName());
        presLast.setText(president.getLastName());
        presMail.setText(president.getEmail());
        presPhone.setText(president.getPhone());
        
        Company company = Database.getCompany();
        firmName.setText(company.getName());
        firmMail.setText(company.getEmail());
        firmPhone.setText(company.getPhoneNumber());
    }
    
    private void initLedger() {
        ledgerTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        ledgerTable.getColumnModel().getColumn(0).setPreferredWidth(220);
        ledgerTable.getColumnModel().getColumn(0).setMaxWidth(220);
        
        ledgerTable.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 18));
        ledgerTable.setRowHeight(30);
        
        modelLedger = (DefaultTableModel) ledgerTable.getModel();
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        for(Entry entry : Database.getLedger().getEntries()) {
            modelLedger.addRow(new Object[]{dt.format(entry.getDate()), entry.getMessage()});
        }
        ledgerTable.changeSelection(ledgerTable.getRowCount() - 1, 0, false, false);
    }
    
    private void initMain() {
        Owner owner = Options.loggedIn;
        fullName.setText(owner.getFirstName() + " " + owner.getLastName());
        email.setText(owner.getEmail());
        phone.setText(owner.getPhone());
        buildingBalance.setText(Database.getBuilding().getTotalMoney() + "€");
        modelMain = (DefaultTableModel) mainTable.getModel();
        for(Apartment apartment : owner.getApartments()) {
            modelMain.addRow(new Object[]{apartment.getNumber(), String.format("%.2f", apartment.getBalance())});
        }
        mainTable.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 18));
        mainTable.setRowHeight(30);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        fullName = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buildingBalance = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ledgerTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        presFirst = new javax.swing.JLabel();
        presLast = new javax.swing.JLabel();
        presMail = new javax.swing.JLabel();
        presPhone = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        firmName = new javax.swing.JLabel();
        firmPhone = new javax.swing.JLabel();
        firmMail = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notifTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stanar");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClose(evt);
            }
        });

        fullName.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        fullName.setText("TEXT");

        email.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        email.setText("TEXT");

        phone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        phone.setText("TEXT");

        mainTable.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Broj stana", "Stanje na računu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mainTable);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Račun zgrade:");

        buildingBalance.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        buildingBalance.setText("TEXT");

        jButton1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton1.setText("Pošalji žalbu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaint(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton2.setText("Log out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phone)
                    .addComponent(email)
                    .addComponent(fullName)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buildingBalance)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(fullName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buildingBalance)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Početna", jPanel1);

        ledgerTable.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        ledgerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum i vreme", "Poruka"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ledgerTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dnevnik", jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel2.setText("Predsednik");

        presFirst.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presFirst.setText("TEXT");

        presLast.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presLast.setText("TEXT");

        presMail.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presMail.setText("TEXT");

        presPhone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presPhone.setText("TEXT");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel7.setText("Firma");

        firmName.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmName.setText("TEXT");

        firmPhone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmPhone.setText("TEXT");

        firmMail.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmMail.setText("TEXT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(presFirst)
                    .addComponent(presLast)
                    .addComponent(presMail)
                    .addComponent(presPhone))
                .addGap(100, 100, 100)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firmPhone)
                    .addComponent(firmName)
                    .addComponent(jLabel7)
                    .addComponent(firmMail))
                .addContainerGap(445, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presFirst)
                    .addComponent(firmName))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presLast)
                    .addComponent(firmMail))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presMail)
                    .addComponent(firmPhone))
                .addGap(18, 18, 18)
                .addComponent(presPhone)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kontakti", jPanel3);

        notifTable.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        notifTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum i vreme", "Poruka"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(notifTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Obaveštenja", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("ASDASD");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void complaint(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaint
        Complaint dialog = new Complaint();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_complaint

    private void onClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClose
        WriteFile.saveDB();
    }//GEN-LAST:event_onClose

    private void logout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout
        Options.loggedIn = null;
        Manger.login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buildingBalance;
    private javax.swing.JLabel email;
    private javax.swing.JLabel firmMail;
    private javax.swing.JLabel firmName;
    private javax.swing.JLabel firmPhone;
    private javax.swing.JLabel fullName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable ledgerTable;
    private javax.swing.JTable mainTable;
    public javax.swing.JTable notifTable;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel presFirst;
    private javax.swing.JLabel presLast;
    private javax.swing.JLabel presMail;
    private javax.swing.JLabel presPhone;
    // End of variables declaration//GEN-END:variables
}
