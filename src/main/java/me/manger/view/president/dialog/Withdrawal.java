package me.manger.view.president.dialog;

import javax.swing.JFrame;
import me.manger.model.Database;
import me.manger.model.Apartment;
import me.manger.view.president.PresidentFrame;

public class Withdrawal extends javax.swing.JFrame {

    PresidentFrame frame;
    
    public Withdrawal(PresidentFrame frame) {
        this.frame = frame;
        initComponents();
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amountSpinner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Izvrsi isplatu");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Iznos: ");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Opis");

        amountSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        amountSpinner.setMinimumSize(new java.awt.Dimension(100, 25));
        amountSpinner.setPreferredSize(new java.awt.Dimension(100, 25));

        jButton1.setText("Ponisti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel(evt);
            }
        });

        jButton2.setText("Isplati");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdraw(evt);
            }
        });

        messageArea.setColumns(20);
        messageArea.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        messageArea.setLineWrap(true);
        messageArea.setRows(5);
        jScrollPane1.setViewportView(messageArea);

        error.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(error))
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel
        this.setVisible(false);
    }//GEN-LAST:event_cancel

    private void withdraw(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdraw
        String message = messageArea.getText();
        double amount = (double) amountSpinner.getValue();
        if(amount <= 0) {
            error.setText("Iznos <=0 nije podrzan");
            return;
        }
        if(amount > Database.getBuilding().getTotalMoney()) {
            error.setText("Nedovoljno para na racunu zgrade");
            return;
        }
        if(message.isEmpty()) {
            error.setText("Unesite opis");
            return;
        }
        Database.getBuilding().withdraw(amount);
        int counter = 0;
        for(Apartment temp : Database.getBuilding().getApartments()) {
            if(!temp.getOwners().isEmpty() || temp.getBalance() > 0) {
                counter++;
            }
        }
        for(Apartment temp : Database.getBuilding().getApartments()) {
            if(temp.getOwners().isEmpty() || temp.getBalance() > 0) {
                continue;
            }
            System.out.println(amount / counter);
            temp.withdraw(amount / counter);
        }
        Database.getLedger().addEntry("Skinuto " + amount + "€: " + message);
        frame.refreshLedger();
        frame.refreshAptBalance();
        frame.refreshBuildingBalance();
        this.setVisible(false);
    }//GEN-LAST:event_withdraw

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageArea;
    // End of variables declaration//GEN-END:variables
}
