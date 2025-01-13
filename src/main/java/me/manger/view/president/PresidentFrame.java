package me.manger.view.president;

import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import me.manger.Manger;
import me.manger.db.WriteFile;
import me.manger.model.Apartment;
import me.manger.model.Company;
import me.manger.model.Database;
import me.manger.model.Notification;
import me.manger.model.ledger.Entry;
import me.manger.model.user.Owner;
import me.manger.model.user.President;
import me.manger.view.president.dialog.Deposit;
import me.manger.view.president.dialog.Meeting;
import me.manger.view.president.dialog.Withdrawal;

public class PresidentFrame extends javax.swing.JFrame {
    
    DefaultTableModel modelLedger;
    DefaultTableModel modelNotif;

    public PresidentFrame() {
        initComponents();
        initMain();
        initLedger();
        initContact();
        initNotif();
        
        ledgerTable.setDefaultEditor(Object.class, null);
        notifTable.setDefaultEditor(Object.class, null);
    }
    
    private void initNotif() {
        notifTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        notifTable.getColumnModel().getColumn(0).setPreferredWidth(220);
        notifTable.getColumnModel().getColumn(0).setMaxWidth(220);
        
        notifTable.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 18));
        notifTable.setRowHeight(30);
        
        refreshNotifs();
    }
    
    public void refreshNotifs() {
        modelNotif = (DefaultTableModel) notifTable.getModel();
        modelNotif.setRowCount(0);
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        for(Notification notif : Database.getPresident().getNotifications()){
            modelNotif.addRow(new Object[]{dt.format(notif.getDate()), notif.getMessage()});
        }
        notifTable.changeSelection(notifTable.getRowCount() - 1, 0, false, false);
    }
    
    private void initContact() {
        Company company = Database.getCompany();
        firmName.setText(company.getName());
        firmMail.setText(company.getEmail());
        firmPhone.setText(company.getPhoneNumber());
    }
    
    private void initMain() {
        President president = Database.getPresident();
        fullName.setText(president.getFirstName() + " " + president.getLastName());
        email.setText(president.getEmail());
        phone.setText(president.getPhone());
        buildingBalance.setText(Database.getBuilding().getTotalMoney() + "€");
        
        DefaultListModel lm = new DefaultListModel();
        for(Apartment temp : Database.getBuilding().getApartments()) {
            lm.addElement(String.valueOf(temp.getNumber()));
        }
        apartmentList.setModel(lm);
    }
    
    public void refreshAptBalance() {
        Apartment apartment;
        try {
            apartment = search(Integer.parseInt(apartmentList.getSelectedValue()));
        } catch(NumberFormatException e) {
            return;
        }
        if(apartment == null) {
            return;
        }
        aptBalance.setText(String.format("%.2f", apartment.getBalance()) + "€");
    }
    
    public void refreshBuildingBalance() {
        buildingBalance.setText(String.valueOf(Database.getBuilding().getTotalMoney()));
    }
    
    private void initLedger() {
        ledgerTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        ledgerTable.getColumnModel().getColumn(0).setPreferredWidth(220);
        ledgerTable.getColumnModel().getColumn(0).setMaxWidth(220);
        
        ledgerTable.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 18));
        ledgerTable.setRowHeight(30);
        
        refreshLedger();
    }
    
    public void refreshLedger() {
        modelLedger = (DefaultTableModel) ledgerTable.getModel();
        modelLedger.setRowCount(0);
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        for(Entry entry : Database.getLedger().getEntries()) {
            modelLedger.addRow(new Object[]{dt.format(entry.getDate()), entry.getMessage()});
        }
        ledgerTable.changeSelection(ledgerTable.getRowCount() - 1, 0, false, false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buildingBalance = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fullName = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        apartmentList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        aptNumber = new javax.swing.JLabel();
        aptBalance = new javax.swing.JLabel();
        aptArea = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ownerList = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ledgerTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        firmName = new javax.swing.JLabel();
        firmMail = new javax.swing.JLabel();
        firmPhone = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notifTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Predsednik");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClose(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Račun zgrade:");

        buildingBalance.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        buildingBalance.setText("TEXT");

        jButton1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton1.setText("Izvrši uplatu");
        jButton1.setToolTipText("");
        jButton1.setMaximumSize(new java.awt.Dimension(200, 39));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 39));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 39));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deposit(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton2.setText("Izvrši isplatu");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawal(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton3.setText("Zakazi sastanak");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sastanak(evt);
            }
        });

        fullName.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        fullName.setText("TEXT");

        email.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        email.setText("TEXT");

        phone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        phone.setText("TEXT");

        apartmentList.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        apartmentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        apartmentList.setPreferredSize(new java.awt.Dimension(100, 175));
        apartmentList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                click(evt);
            }
        });
        jScrollPane2.setViewportView(apartmentList);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Stanovi");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Broj stana: ");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Površina: ");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Stanje na računu: ");

        aptNumber.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        aptBalance.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        aptArea.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        ownerList.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jScrollPane6.setViewportView(ownerList);

        jButton4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton4.setText("Log out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildingBalance))
                    .addComponent(email)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone)
                    .addComponent(fullName))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aptNumber)
                                    .addComponent(aptBalance)
                                    .addComponent(aptArea)))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(96, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fullName)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(phone)
                                .addGap(60, 60, 60)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(buildingBalance)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(aptNumber))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(aptArea))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(aptBalance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
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
        jScrollPane7.setViewportView(ledgerTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dnevnik", jPanel2);

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel9.setText("Firma");

        firmName.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmName.setText("TEXT");

        firmMail.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmMail.setText("TEXT");

        firmPhone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmPhone.setText("TEXT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firmPhone)
                    .addComponent(firmName)
                    .addComponent(jLabel9)
                    .addComponent(firmMail))
                .addContainerGap(435, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(firmName)
                .addGap(18, 18, 18)
                .addComponent(firmMail)
                .addGap(18, 18, 18)
                .addComponent(firmPhone)
                .addContainerGap(258, Short.MAX_VALUE))
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
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClose
        WriteFile.saveDB();
    }//GEN-LAST:event_onClose

    private void sastanak(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sastanak
        Meeting dialog = new Meeting(this);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_sastanak

    private void withdrawal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawal
        Withdrawal dialog = new Withdrawal(this);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_withdrawal

    private void deposit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deposit
        Deposit dialog = new Deposit(this);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_deposit

    private void logout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout
        Manger.login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout

    private void click(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_click
        Apartment apartment = search(Integer.parseInt(apartmentList.getSelectedValue()));
        if(apartment == null) {
            return;
        }
        aptNumber.setText(String.valueOf(apartment.getNumber()));
        aptArea.setText(String.valueOf(apartment.getArea()));
        aptBalance.setText(String.format("%.2f", apartment.getBalance()) + "€");

        DefaultListModel lm = new DefaultListModel();
        for(Owner temp : apartment.getOwners()) {
            lm.addElement(temp.getFirstName() + " " + temp.getLastName() + " (" + temp.getUsername() + ")");
        }
        ownerList.setModel(lm);
    }//GEN-LAST:event_click
    
    private Apartment search(int number) {
        for(Apartment apartment : Database.getBuilding().getApartments()) {
            if(apartment.getNumber() == number) {
                return apartment;
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> apartmentList;
    private javax.swing.JLabel aptArea;
    private javax.swing.JLabel aptBalance;
    private javax.swing.JLabel aptNumber;
    private javax.swing.JLabel buildingBalance;
    private javax.swing.JLabel email;
    private javax.swing.JLabel firmMail;
    private javax.swing.JLabel firmName;
    private javax.swing.JLabel firmPhone;
    private javax.swing.JLabel fullName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable ledgerTable;
    private javax.swing.JTable notifTable;
    private javax.swing.JList<String> ownerList;
    private javax.swing.JLabel phone;
    // End of variables declaration//GEN-END:variables
}
