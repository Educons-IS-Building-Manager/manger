package me.manger.view.admin;

import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import me.manger.Manger;
import me.manger.db.WriteFile;
import me.manger.model.Apartment;
import me.manger.model.Company;
import me.manger.model.Database;
import me.manger.model.Options;
import me.manger.model.ledger.Entry;
import me.manger.model.user.Owner;
import me.manger.model.user.President;
import me.manger.view.admin.dialog.EditOwner;

public class AdminFrame extends javax.swing.JFrame {

    DefaultTableModel modelLedger;
    DefaultTableModel modelOwners;
    
    public AdminFrame() {
        initComponents();
        initMain();
        initLedger();
        initOwners();
        initApts();
    }
    
    private void initApts() {
        refreshApts();
    }
    
    public void refreshApts() {
        DefaultListModel lm = new DefaultListModel();
        for(Apartment temp : Database.getBuilding().getApartments()) {
            lm.addElement(String.valueOf(temp.getNumber()));
        }
        aptList.setModel(lm);
    }
    
    private void initOwners() {
        ownersTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        ownersTable.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 14));
        ownersTable.setRowHeight(30);
        
        refreshOwners();
    }
    
    public void refreshOwners() {
        modelOwners = (DefaultTableModel) ownersTable.getModel();
        modelOwners.setRowCount(0);
        for(Owner owner : Database.getOwners()) {
            modelOwners.addRow(new Object[]{owner.getFirstName() + " " + owner.getLastName(), owner.getEmail(), owner.getPhone(), owner.getUsername()});
        }
        ownersTable.changeSelection(0, 0, false, false);
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
    
    private void initMain() {
        President president = Database.getPresident();
        presFirst.setText(president.getFirstName());
        presLast.setText(president.getLastName());
        presMail.setText(president.getEmail());
        presPhone.setText(president.getPhone());
        
        Company company = Database.getCompany();
        firmName.setText(company.getName());
        firmMail.setText(company.getEmail());
        firmPhone.setText(company.getPhoneNumber());
        
        buildingBalance.setText(String.valueOf(Database.getBuilding().getTotalMoney()) + "€");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buildingBalance = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        firmPhone = new javax.swing.JLabel();
        presPhone = new javax.swing.JLabel();
        presMail = new javax.swing.JLabel();
        presLast = new javax.swing.JLabel();
        presFirst = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        firmName = new javax.swing.JLabel();
        firmMail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ledgerTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ownersTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        aptList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        number = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        aptOwnersTable = new javax.swing.JTable();
        removeFromApt = new javax.swing.JButton();
        addToApt = new javax.swing.JButton();
        ownerBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClose(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Racun zgrade:");

        buildingBalance.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        buildingBalance.setText("TEXT");

        jButton2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton2.setText("Log out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel3.setText("Predsednik");

        firmPhone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmPhone.setText("TEXT");

        presPhone.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presPhone.setText("TEXT");

        presMail.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presMail.setText("TEXT");

        presLast.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presLast.setText("TEXT");

        presFirst.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        presFirst.setText("TEXT");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel8.setText("Firma");

        firmName.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmName.setText("TEXT");

        firmMail.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        firmMail.setText("TEXT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buildingBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(presFirst)
                    .addComponent(presLast)
                    .addComponent(presMail)
                    .addComponent(presPhone))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firmPhone)
                    .addComponent(firmName)
                    .addComponent(jLabel8)
                    .addComponent(firmMail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presFirst)
                    .addComponent(firmName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presLast)
                    .addComponent(firmMail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presMail)
                    .addComponent(firmPhone))
                .addGap(18, 18, 18)
                .addComponent(presPhone)
                .addGap(141, 141, 141)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buildingBalance)
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
                .addContainerGap(50, Short.MAX_VALUE))
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

        jButton1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton1.setText("Dodaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOwner(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton3.setText("Izbrisi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOwner(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton5.setText("Izmeni");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOwner(evt);
            }
        });

        ownersTable.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        ownersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ime i prezime", "Email", "Telefon", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ownersTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButton1)
                        .addGap(156, 156, 156)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(139, 139, 139))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Korisnici", jPanel5);

        aptList.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        aptList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                click(evt);
            }
        });
        jScrollPane3.setViewportView(aptList);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Povrsina:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setText("Broj stana:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setText("Stanje na racunu:");

        number.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        area.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        balance.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        aptOwnersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ime i prezime", "Telefon", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(aptOwnersTable);

        removeFromApt.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        removeFromApt.setForeground(new java.awt.Color(255, 51, 0));
        removeFromApt.setText("-");
        removeFromApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromApt(evt);
            }
        });

        addToApt.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        addToApt.setForeground(new java.awt.Color(0, 255, 0));
        addToApt.setText("+");
        addToApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToApt(evt);
            }
        });

        ownerBox.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(number)
                            .addComponent(area)
                            .addComponent(balance))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ownerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addToApt)
                .addGap(18, 18, 18)
                .addComponent(removeFromApt)
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(number))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(area))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(balance))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeFromApt)
                    .addComponent(addToApt)
                    .addComponent(ownerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stanovi", jPanel6);

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

    private void onClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClose
        WriteFile.saveDB();
    }//GEN-LAST:event_onClose

    private void logout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout
        Options.loggedIn = null;
        Manger.login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout

    private void editOwner(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOwner
        if(ownersTable.getSelectionModel().isSelectionEmpty()) {
            return;
        }
        EditOwner dialog = new EditOwner(1, ownersTable, this);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_editOwner

    private void addOwner(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOwner
        EditOwner dialog = new EditOwner(0, ownersTable, this);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_addOwner

    private void deleteOwner(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOwner
        if(ownersTable.getSelectionModel().isSelectionEmpty()) {
            return;
        }
        
        // Confirmation Dialog
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(300, 50));
        panel.setLayout(null);
        int res = JOptionPane.showConfirmDialog(null, "Da li zelite da obrisete korisnika?", "Potvrda", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(res != 0) {
            return;
        }
        
        Owner owner = searchOwnerInList((String) ownersTable.getValueAt(ownersTable.getSelectedRow(), 3), Database.getOwners());
        System.out.println(owner.getUsername());
        for(Apartment apartment : owner.getApartments()) {
            apartment.getOwners().remove(owner);
        }
        Database.getOwners().remove(owner);
        Database.getLedger().addEntry("Korisnik " + owner.getUsername() + " je obrisan");
        
        refreshLedger();
        refreshOwners();
        populateTable();
        populateCombo();
    }//GEN-LAST:event_deleteOwner

    private void removeFromApt(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromApt
        if(aptList.getSelectionModel().isSelectionEmpty()) {
            return;
        }
        
        Apartment apartment;
        Owner owner;
        apartment = searchApartment(Integer.parseInt(aptList.getSelectedValue()));
        try {
            owner = searchOwnerInList((String) aptOwnersTable.getValueAt(aptOwnersTable.getSelectedRow(), 2), apartment.getOwners());
        } catch(ArrayIndexOutOfBoundsException e) {
            return;
        }
        apartment.getOwners().remove(owner);
        owner.getApartments().remove(apartment);
        Database.getLedger().addEntry("Sklonjen " + owner.getUsername() + " kao vlasnik stana #" + apartment.getNumber());
        
        refreshLedger();
        populateTable();
        populateCombo();
    }//GEN-LAST:event_removeFromApt

    private void addToApt(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToApt
        Apartment apartment;
        Owner owner;
        try {
            apartment = searchApartment(Integer.parseInt(aptList.getSelectedValue()));
        } catch(NumberFormatException e) {
            return;
        }
        try {
            owner = searchOwnerInList(ownerBox.getSelectedItem().toString(), Database.getOwners());
        } catch(NullPointerException e) {
            return;
        }
        apartment.getOwners().add(owner);
        owner.getApartments().add(apartment);
        Database.getLedger().addEntry("Dodat " + owner.getUsername() + " kao vlasnik stana #" + apartment.getNumber());
        
        refreshLedger();
        populateTable();
        populateCombo();
    }//GEN-LAST:event_addToApt

    private void click(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_click
        Apartment apartment = searchApartment(Integer.parseInt(aptList.getSelectedValue()));
        if(apartment == null) {
            return;
        }
        
        number.setText(String.valueOf(apartment.getNumber()));
        area.setText(String.valueOf(apartment.getArea()));
        balance.setText(String.format("%.2f", apartment.getBalance()) + "€");
        
        populateTable();
        populateCombo();
    }//GEN-LAST:event_click

    public void populateCombo() {
        if(aptList.getSelectedValue() == null) {
            return;
        }
        Apartment apartment = searchApartment(Integer.parseInt(aptList.getSelectedValue()));
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) ownerBox.getModel();
        comboModel.removeAllElements();
        for(Owner owner : Database.getOwners()) {
            if(!findInList(owner, apartment.getOwners())) {
                comboModel.addElement(owner.getUsername());
            }
        }
        try {
            ownerBox.setSelectedIndex(0);
        } catch(IllegalArgumentException e) {
        }
    }
    
    public void populateTable() {
        if(aptList.getSelectedValue() == null) {
            return;
        }
        Apartment apartment = searchApartment(Integer.parseInt(aptList.getSelectedValue()));
        DefaultTableModel lm = (DefaultTableModel) aptOwnersTable.getModel();
        lm.setRowCount(0);
        for(Owner temp : apartment.getOwners()) {
            lm.addRow(new Object[]{temp.getFirstName() + " " + temp.getLastName(), temp.getPhone(), temp.getUsername()});
        }
        aptOwnersTable.changeSelection(0, 0, false, false);
    }
    
    private <T> boolean findInList(T object, List<T> list) {
        for(T temp : list) {
            if(temp == object) {
                return true;
            }
        }
        return false;
    }
    
    private Apartment searchApartment(int number) {
        for(Apartment apartment : Database.getBuilding().getApartments()) {
            if(apartment.getNumber() == number) {
                return apartment;
            }
        }
        return null;
    }
    
    private Owner searchOwnerInList(String username, List<Owner> list) {
        for(Owner temp : list) {
            if(temp.getUsername().equals(username)) {
                return temp;
            }
        }
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToApt;
    private javax.swing.JList<String> aptList;
    private javax.swing.JTable aptOwnersTable;
    private javax.swing.JLabel area;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel buildingBalance;
    private javax.swing.JLabel firmMail;
    private javax.swing.JLabel firmName;
    private javax.swing.JLabel firmPhone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable ledgerTable;
    private javax.swing.JLabel number;
    private javax.swing.JComboBox<String> ownerBox;
    private javax.swing.JTable ownersTable;
    private javax.swing.JLabel presFirst;
    private javax.swing.JLabel presLast;
    private javax.swing.JLabel presMail;
    private javax.swing.JLabel presPhone;
    private javax.swing.JButton removeFromApt;
    // End of variables declaration//GEN-END:variables
}
