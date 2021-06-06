/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkp;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rezabdullah
 */
public class Receiving extends javax.swing.JFrame {
    String idShipping;
    
    private void resetForm(){
        inputRecipient.setText(null);
        inputAddress.setText(null);
        inputPhone.setText(null);
        inputItemName.setText(null);
        inputItemWeight.setText(null);
        inputItemQuantity.setText(null);
        inputPackQuantity.setText(null);
        inputShippingType.setText(null);
        inputNote.setText(null);
    }
    
    private void showData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("AWB");
        model.addColumn("Sender");
        model.addColumn("Recipient");
        model.addColumn("Address");
        model.addColumn("Phone number");
        model.addColumn("Item Name");
        model.addColumn("Weight");
        model.addColumn("Quantity");
        model.addColumn("Packing");
        model.addColumn("Pack Quantity");
        model.addColumn("Shipping Type");
        model.addColumn("Amount");
        model.addColumn("Officer");
        model.addColumn("Status");
        model.addColumn("Note");
        
        try{
            java.sql.Connection con = Database.ConnectDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery("select s.id, c.nama as `sender_name`, s.recipient_name, s.recipient_address, s.recipient_phone, s.item_name, s.item_weight, s.item_qty, p.nama as `pack_name`, s.pack_qty, s.ship_type, s.amount, a.fullname as `officer`, sp.status, .sp.note from shipping s inner join admin a on s.id_sender = a.id inner join customer c on s.id_sender = c.id inner join pack p on s.id_pack = p.id inner join shipping_detail sp on s.id = sp.id_shipping where sp.status = 'receiving'");
            
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("sender_name"),
                    res.getString("recipient_name"),
                    res.getString("recipient_address"),
                    res.getString("recipient_phone"),
                    res.getString("item_name"),
                    res.getString("item_weight"),
                    res.getString("item_qty"),
                    res.getString("pack_name"),
                    res.getString("pack_qty"),
                    res.getString("ship_type"),
                    res.getString("amount"),
                    res.getString("officer"),
                    res.getString("status"),
                    res.getString("note")
                });
            }
            
            tableReceiving.setModel(model);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public void setSender()
    {        
        try{
            java.sql.Connection con = Database.ConnectDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery("select id, nama from customer");
            
            while(res.next()){
                int index = Integer.parseInt(res.getString(1));
                String name = res.getString(2);
                SetComboBoxValue data = new SetComboBoxValue(index,name);
                inputSender.addItem(data);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setPacking()
    {        
        try{
            java.sql.Connection con = Database.ConnectDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery("select id, nama from pack");
            
            while(res.next()){
                int index = Integer.parseInt(res.getString(1));
                String name = res.getString(2);
                SetComboBoxValue data = new SetComboBoxValue(index,name);
                inputPackingType.addItem(data);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Creates new form Receiving
     */
    public Receiving() {
        initComponents();
        showData();
        setSender();
        setPacking();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputItemName = new javax.swing.JTextField();
        inputPhone = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceiving = new javax.swing.JTable();
        labelItemName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelAdminTitle = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        inputRecipient = new javax.swing.JTextField();
        labelSender = new javax.swing.JLabel();
        labeAddress = new javax.swing.JLabel();
        inputAddress = new javax.swing.JTextField();
        labelPhone = new javax.swing.JLabel();
        labelRecipient = new javax.swing.JLabel();
        inputSender = new javax.swing.JComboBox<>();
        labelItemWeight = new javax.swing.JLabel();
        inputItemWeight = new javax.swing.JTextField();
        labelItemQuantity = new javax.swing.JLabel();
        inputItemQuantity = new javax.swing.JTextField();
        labelPackingType = new javax.swing.JLabel();
        inputPackingType = new javax.swing.JComboBox<>();
        labelPackQuantity = new javax.swing.JLabel();
        inputPackQuantity = new javax.swing.JTextField();
        labelShippingType = new javax.swing.JLabel();
        inputShippingType = new javax.swing.JTextField();
        labelNote = new javax.swing.JLabel();
        inputNote = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputItemNameActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(245, 59, 87));
        btnNew.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("ADD NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(245, 59, 87));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(245, 59, 87));
        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET FORM");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tableReceiving.setModel(new javax.swing.table.DefaultTableModel(
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
        tableReceiving.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceivingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReceiving);

        labelItemName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelItemName.setText("Item Name");

        jPanel1.setBackground(new java.awt.Color(245, 59, 87));

        labelAdminTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelAdminTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelAdminTitle.setText("RECEIVING");

        btnback.setBackground(new java.awt.Color(245, 59, 87));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAdminTitle)
                .addGap(628, 628, 628))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdminTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelSender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSender.setText("Sender");

        labeAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labeAddress.setText("Address");

        labelPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPhone.setText("Phone Number");

        labelRecipient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRecipient.setText("Recipient");

        labelItemWeight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelItemWeight.setText("Item Weight");

        labelItemQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelItemQuantity.setText("Item Quantity");

        labelPackingType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPackingType.setText("Packing");

        labelPackQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPackQuantity.setText("Pack Quantity");

        inputPackQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPackQuantityActionPerformed(evt);
            }
        });

        labelShippingType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelShippingType.setText("Shipping Type");

        inputShippingType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputShippingTypeActionPerformed(evt);
            }
        });

        labelNote.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNote.setText("Note");

        inputNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSender)
                            .addComponent(labelRecipient)
                            .addComponent(labeAddress)
                            .addComponent(labelPhone)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputRecipient, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputSender, javax.swing.GroupLayout.Alignment.LEADING, 0, 234, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelItemName)
                            .addComponent(labelItemWeight)
                            .addComponent(labelItemQuantity)
                            .addComponent(labelPackingType)
                            .addComponent(labelNote)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelPackQuantity)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputItemName)
                                    .addComponent(inputItemWeight)
                                    .addComponent(inputItemQuantity, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputPackingType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(inputPackQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelShippingType)
                                .addComponent(inputShippingType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputNote, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputSender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelRecipient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labeAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelItemWeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputItemWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelItemQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPackingType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPackingType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelPackQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputPackQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelShippingType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputShippingType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNote, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        int qty = Integer.parseInt(inputItemQuantity.getText());
        int weight = Integer.parseInt(inputItemWeight.getText());
        
        SetComboBoxValue getInputSender = (SetComboBoxValue) inputSender.getSelectedItem();
        int inputSenderID = getInputSender.GetIndex();
        
        SetComboBoxValue getInputPackingType = (SetComboBoxValue) inputPackingType.getSelectedItem();
        int inputPackingTypeID = getInputPackingType.GetIndex();
        
        try{
            java.sql.Connection con = Database.ConnectDB();
            java.sql.PreparedStatement stm = con.prepareStatement("INSERT INTO shipping VALUES(null, '" + inputSenderID +
                "', '" + inputRecipient.getText() + "', '" + inputAddress.getText() + "', '" + inputPhone.getText() + 
                "', '" + inputItemName.getText() + "', '" + inputItemQuantity.getText() + "', '" + inputItemWeight.getText() + 
                    "', '" + inputPackingTypeID + "', '" + inputShippingType.getText() + "', '" + inputPackQuantity.getText() + 
                    "', '" + (qty * weight * 10000) + "', 'unpaid')", RETURN_GENERATED_KEYS);
            stm.execute();
            ResultSet rs= stm.getGeneratedKeys();
            
            if (rs.next()) 
            {
                String idshipping = rs.getString(1);
                
                java.sql.PreparedStatement stm1 = con.prepareStatement("INSERT INTO shipping_detail VALUES(null, '" + idshipping +
                "', '" + Session.id + "', 'receiving', '" + inputNote.getText() + "')");
                stm1.execute();
            }    

            JOptionPane.showMessageDialog(null, "Data tersimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            showData();
            resetForm();
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            SetComboBoxValue getInputSender = (SetComboBoxValue) inputSender.getSelectedItem();
            int inputSenderID = getInputSender.GetIndex();

            SetComboBoxValue getInputPackingType = (SetComboBoxValue) inputPackingType.getSelectedItem();
            int inputPackingTypeID = getInputPackingType.GetIndex();

            java.sql.Connection con = Database.ConnectDB();
            java.sql.PreparedStatement stm = con.prepareStatement("UPDATE shipping SET id_sender='" + inputSenderID +
                "', recipient_name='" + inputRecipient.getText() + "', recipient_address='" + inputAddress.getText() +
                "', recipient_phone='" + inputPhone.getText() + "', item_name='" + inputItemName.getText() + 
                "', item_weight='" + inputItemWeight.getText() + "', item_qty='" + inputItemQuantity.getText() + 
                "', id_pack='" + inputPackingTypeID + "', ship_type='" + inputShippingType.getText() + 
                "', pack_qty='" + inputPackQuantity.getText() + 
                "' WHERE id='" + this.idShipping + "'");
            stm.execute();
            
            java.sql.PreparedStatement stm1 = con.prepareStatement("UPDATE shipping_detail SET note='" + inputNote.getText() + 
                "' WHERE id_shipping='" + this.idShipping + "' AND status='receiving'");
            stm1.execute();

            JOptionPane.showMessageDialog(null, "Data terupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            showData();
            resetForm();
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableReceivingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceivingMouseClicked
        int rowPoint = tableReceiving.rowAtPoint(evt.getPoint());

        this.idShipping = tableReceiving.getValueAt(rowPoint, 0).toString();

        String getRecipient = tableReceiving.getValueAt(rowPoint, 2).toString();
        inputRecipient.setText(getRecipient);

        String getAddress = tableReceiving.getValueAt(rowPoint, 3).toString();
        inputAddress.setText(getAddress);

        String getPhone = tableReceiving.getValueAt(rowPoint, 4).toString();
        inputPhone.setText(getPhone);
        
        String getItemName = tableReceiving.getValueAt(rowPoint, 5).toString();
        inputItemName.setText(getItemName);
        
        String getItemWeight = tableReceiving.getValueAt(rowPoint, 6).toString();
        inputItemWeight.setText(getItemWeight);
        
        String getItemQty = tableReceiving.getValueAt(rowPoint, 7).toString();
        inputItemQuantity.setText(getItemQty);
        
        String getPackQty = tableReceiving.getValueAt(rowPoint, 9).toString();
        inputPackQuantity.setText(getPackQty);
        
        String getShipping = tableReceiving.getValueAt(rowPoint, 10).toString();
        inputShippingType.setText(getShipping);
        
        String getNote = tableReceiving.getValueAt(rowPoint, 14).toString();
        inputNote.setText(getNote);
    }//GEN-LAST:event_tableReceivingMouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void inputPackQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPackQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPackQuantityActionPerformed

    private void inputShippingTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputShippingTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputShippingTypeActionPerformed

    private void inputNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNoteActionPerformed

    private void inputItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputItemNameActionPerformed

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
            java.util.logging.Logger.getLogger(Receiving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receiving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receiving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receiving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Receiving Page = new Receiving();
                Page.setVisible(true);
                Page.setExtendedState(Page.MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnback;
    private javax.swing.JTextField inputAddress;
    private javax.swing.JTextField inputItemName;
    private javax.swing.JTextField inputItemQuantity;
    private javax.swing.JTextField inputItemWeight;
    private javax.swing.JTextField inputNote;
    private javax.swing.JTextField inputPackQuantity;
    private javax.swing.JComboBox<SetComboBoxValue> inputPackingType;
    private javax.swing.JTextField inputPhone;
    private javax.swing.JTextField inputRecipient;
    private javax.swing.JComboBox<SetComboBoxValue> inputSender;
    private javax.swing.JTextField inputShippingType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labeAddress;
    private javax.swing.JLabel labelAdminTitle;
    private javax.swing.JLabel labelItemName;
    private javax.swing.JLabel labelItemQuantity;
    private javax.swing.JLabel labelItemWeight;
    private javax.swing.JLabel labelNote;
    private javax.swing.JLabel labelPackQuantity;
    private javax.swing.JLabel labelPackingType;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelRecipient;
    private javax.swing.JLabel labelSender;
    private javax.swing.JLabel labelShippingType;
    private javax.swing.JTable tableReceiving;
    // End of variables declaration//GEN-END:variables
}
