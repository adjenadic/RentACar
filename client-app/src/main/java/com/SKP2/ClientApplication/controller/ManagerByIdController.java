package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ManagerByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Manager By ID:");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblManagerID = new JLabel("Manager ID");
        lblManagerID.setBounds(40, 70, 250, 30);
        jDialog.add(lblManagerID);

        JTextField tfManagerID = new JTextField();
        tfManagerID.setBounds(40, 100, 250, 30);
        jDialog.add(tfManagerID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ManagerDto managerDto = MainFrame.getInstance().getUserService().getManagerById(Long.parseLong(tfManagerID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + managerDto.getId() + "\nUsername: " + managerDto.getUsername() + "\nPassword: " + managerDto.getPassword()
                        + "\nEmail: " + managerDto.getEmail() + "\nDate of Birth: " + managerDto.getDayOfBirth() + "\nFirst name: " + managerDto.getFirstName() + "\nLast name: " + managerDto.getLastName()
                        + "\nCompany name: " + managerDto.getCompanyName() + "\nEmployment day: " + managerDto.getEmploymentDay(), "Manager " + tfManagerID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
