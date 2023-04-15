package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TypeByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setSize(1024, 768);

        JLabel lblGet = new JLabel("Get Type By ID");
        lblGet.setBounds(40, 40, 250, 30);
        jDialog.add(lblGet);

        JLabel lblTypeID = new JLabel("Type ID");
        lblTypeID.setBounds(40, 70, 250, 30);
        jDialog.add(lblTypeID);

        JTextField tfTypeID = new JTextField();
        tfTypeID.setBounds(40, 100, 250, 30);
        jDialog.add(tfTypeID);

        JButton btnGet = new JButton("Get");
        btnGet.setBounds(40, 130, 250, 30);
        jDialog.add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                TypeDto typeDto = MainFrame.getInstance().getRentalService().getTypeById(Long.parseLong(tfTypeID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + typeDto.getId() + "\nName: " + typeDto.getName(), "Type " + tfTypeID.getText(), JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jDialog.setVisible(true);
    }
}
