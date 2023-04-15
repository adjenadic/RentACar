package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.NotificationTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NotifTypeByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Notification Type By ID");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblID = new JLabel("Notification Type ID");
        lblID.setBounds(40, 70, 250, 30);
        jDialog.add(lblID);

        JTextField tfID = new JTextField();
        tfID.setBounds(40, 100, 250, 30);
        jDialog.add(tfID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                NotificationTypeDto notificationTypeDto = MainFrame.getInstance().getNotificationService().getNotificationTypeById(Long.parseLong(tfID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + notificationTypeDto.getId() + "\nName: " + notificationTypeDto.getName(), "Notification Type " + tfID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
