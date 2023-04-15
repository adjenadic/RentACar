package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.NotificationTypeCreateDto;
import com.SKP2.ClientApplication.dto.NotificationTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterNotifTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblAdd = new JLabel("Add Notification Type");
        lblAdd.setBounds(40, 40, 250, 30);
        jDialog.add(lblAdd);

        JLabel lblName = new JLabel("Notification Name");
        lblName.setBounds(40, 70, 250, 30);
        jDialog.add(lblName);

        JTextField tfName = new JTextField();
        tfName.setBounds(40, 100, 250, 30);
        jDialog.add(tfName);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(40, 130, 250, 30);
        jDialog.add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                NotificationTypeCreateDto notificationTypeCreateDto = new NotificationTypeCreateDto(tfName.getText());
                NotificationTypeDto notificationTypeDto = MainFrame.getInstance().getNotificationService().registerNotificationType(notificationTypeCreateDto);
                JOptionPane.showMessageDialog(null, "Notification type successfully added.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Notification type not added!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
