package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.NotificationTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateNotifTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblUpdate = new JLabel("Update Notification Type");
        lblUpdate.setBounds(40, 40, 250, 30);
        jDialog.add(lblUpdate);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40, 130, 250, 30);
        jDialog.add(lblName);

        JTextField tfName = new JTextField();
        tfName.setBounds(40, 160, 250, 30);
        jDialog.add(tfName);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(40, 190, 250, 30);
        jDialog.add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                NotificationTypeDto notificationTypeDto = new NotificationTypeDto(Long.parseLong(tfID.getText()), tfName.getText());
                NotificationTypeDto updatedNotificationTypeDto = MainFrame.getInstance().getNotificationService().updateNotificationType(notificationTypeDto);
                JOptionPane.showMessageDialog(null, "Notification Type " + updatedNotificationTypeDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Notification Type not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
