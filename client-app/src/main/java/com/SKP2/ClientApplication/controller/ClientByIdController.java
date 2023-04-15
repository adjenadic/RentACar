package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Client By ID:");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblUserID = new JLabel("User ID");
        lblUserID.setBounds(40, 70, 250, 30);
        jDialog.add(lblUserID);

        JTextField tfUserID = new JTextField();
        tfUserID.setBounds(40, 100, 250, 30);
        jDialog.add(tfUserID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ClientDto clientDto = MainFrame.getInstance().getUserService().getClientById(Long.parseLong(tfUserID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + clientDto.getId() + "\nUsername: " + clientDto.getUsername() + "\nPassword: " + clientDto.getPassword()
                        + "\nEmail: " + clientDto.getEmail() + "\nDate of Birth: " + clientDto.getDayOfBirth() + "\nFirst name: " + clientDto.getFirstName() + "\nLast name: " + clientDto.getLastName()
                        + "\nPassport: " + clientDto.getPassport(), "Client " + tfUserID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
