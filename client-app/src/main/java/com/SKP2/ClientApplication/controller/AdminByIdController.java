package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.AdminDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Admin By ID");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblAdminID = new JLabel("Admin ID");
        lblAdminID.setBounds(40, 70, 250, 30);
        jDialog.add(lblAdminID);

        JTextField tfAdminID = new JTextField();
        tfAdminID.setBounds(40, 100, 250, 30);
        jDialog.add(tfAdminID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                AdminDto adminDto = MainFrame.getInstance().getUserService().getAdminById(Long.parseLong(tfAdminID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + adminDto.getId() + "\nUsername: " + adminDto.getUsername() + "\nPassword: " + adminDto.getPassword()
                        + "\nEmail: " + adminDto.getEmail() + "\nDate of Birth: " + adminDto.getDayOfBirth() + "\nFirst name: " + adminDto.getFirstName() + "\nLast name: " + adminDto.getLastName(), "Admin " + tfAdminID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
